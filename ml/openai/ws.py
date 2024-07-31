import asyncio
import websockets
from openai import OpenAI
import json

# 调用OpenAI API生成响应

client = OpenAI(

# This is the default and can be omitted

api_key='sk-None-mbjuGSweixVcwybLJEGiT3BlbkFJfPfMAkCjHQEBXjJkh2l4'
)

assistant = client.beta.assistants.create(
name="Clef",
instructions="""
你是Ayden的AI助手，平时帮助用户Ayden解决遇到的编程相关问题，回答markdown的格式的答案帮助用户Ayden编写博客，
""",
tools=[{"type": "code_interpreter"}],
model="gpt-3.5-turbo"
)

thread = client.beta.threads.create()

async def chat(websocket, path):
    async for user_input in websocket:
        json_input = json.loads(user_input)
        final_input = ""
        if(len(json_input['doc'])>0):
            final_input += "我现在正在编写markdown文章，如下是我文章的内容：" + json_input['doc'] + "\n\n"

        final_input += "如下是我的问题：" + json_input["ques"] + "\n\n"

        if(json_input['mode'] == 1):
            final_input += "请帮我续写文档，你的输出会被我直接续写在我的markdown文章后面，直接回复我markdown内容字符串即可，而不需要其他额外的说明"
        else:
            final_input += "正常回答即可，不需要续写文档"

        final_input_len = len(final_input)/4*3
        print(final_input)
        print(final_input_len)
        if final_input_len>4000:
            await websocket.send("输入内容过长！")
            return

        message = client.beta.threads.messages.create(
            thread_id=thread.id,
            role="user",
            content=final_input,
        )

        stream = client.beta.threads.runs.create(
            thread_id=thread.id,
            assistant_id=assistant.id,
            instructions="此时用户在远程问你问题，请用中文生成markdown格式的答案，生成的代码也请放在markdown的代码块里返回给用户",
            stream=True,
        )

        for event in stream:
            event_json = json.loads(event.model_dump_json(indent=2, exclude_unset=True))
            print(event_json)
            # 筛选出状态为 "completed" 的 JSON 数据并发送
            if 'event' in event_json and event_json['event'] == 'thread.message.delta':
                if 'delta' in event_json['data'] and 'content' in event_json['data']['delta'] and len(event_json['data']['delta']['content']) > 0:
                    value = event_json['data']['delta']['content'][0]['text']['value']
                    await websocket.send(value)

start_server = websockets.serve(chat, "localhost", 8765)

asyncio.get_event_loop().run_until_complete(start_server)
asyncio.get_event_loop().run_forever()
