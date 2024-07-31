import asyncio
import websockets
from openai import OpenAI


# 存储对话历史
conversation_history = []

async def chat(websocket, path):
    async for message in websocket:
        # 解析接收到的消息，假设消息格式直接为中文字符串 TODO 修改
        user_input = message

        prompt = """
        我叫Ayden，是一名专注于全栈开发的软件工程师。我拥有一个博客网站fivecheers，里面包含了我的一些coding记录。
        你是嵌入在我的博客网站中的AI助手，平时帮助我解决我遇到的编程问题，在别人问起你或者我的信息时，
        你也负责向他们介绍我以及我的博客。
        """
        
        
        # 更新对话历史
        conversation_history.append({"role": "user", "content": user_input})

        # 构建完整的对话历史
        messages = [{"role": "Ayden的AI编程助手", "content": prompt}] + conversation_history

        # 调用OpenAI API生成响应
        client = OpenAI(
        # This is the default and can be omitted
        api_key=''
        )
        response = client.chat.completions.create(
            model="gpt-3.5-turbo",
            messages=messages
        )

        # 获取AI的回复
        ai_reply = response.choices[0].message['content']

        # 更新对话历史
        conversation_history.append({"role": "assistant", "content": ai_reply})

        # 发送AI的回复给客户端
        await websocket.send(ai_reply)

start_server = websockets.serve(chat, "localhost", 8765)

asyncio.get_event_loop().run_until_complete(start_server)
asyncio.get_event_loop().run_forever()
