import scrapy


class GoogleSpiderSpider(scrapy.Spider):
    name = "google_spider"
    allowed_domains = ["google.com"]
    start_urls = ["https://google.com"]
    

    def parse(self, response):
        print("开始！")
        # 爬取doc
        # filename = "./results/google.html"
        # with open(filename, 'w', encoding='utf-8') as f:
        #     f.write(response.body.decode('utf-8', errors='ignore'))

        # xpath示例
        context = response.xpath('/html/body')
        filename = "./results/tmp.html"
        with open(filename, 'w', encoding='utf-8') as f:
            f.write(context.get())
        # google_pic = context.extract_first()
        # print(google_pic)

        pass