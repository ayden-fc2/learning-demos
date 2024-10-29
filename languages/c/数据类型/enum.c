#include <stdio.h>

// 定义一个枚举类型表示星期几
enum Weekday {
    Sunday,    // 默认值为 0
    Monday,    // 默认值为 1
    Tuesday,   // 默认值为 2
    Wednesday, // 默认值为 3
    Thursday,  // 默认值为 4
    Friday,    // 默认值为 5
    Saturday   // 默认值为 6
};

int main() {
    enum Weekday today;

    // 将 today 设置为 Friday
    today = Friday;

    // 使用 switch 语句根据今天是星期几打印不同的消息
    switch (today) {
        case Sunday:
            printf("今天是星期天。\n");
            break;
        case Monday:
            printf("今天是星期一。\n");
            break;
        case Tuesday:
            printf("今天是星期二。\n");
            break;
        case Wednesday:
            printf("今天是星期三。\n");
            break;
        case Thursday:
            printf("今天是星期四。\n");
            break;
        case Friday:
            printf("今天是星期五。\n");
            break;
        case Saturday:
            printf("今天是星期六。\n");
            break;
        default:
            printf("无效的星期。\n");
            break;
    }

    // 打印枚举类型对应的整数值
    printf("今天是星期几，值为: %d\n", today);

    return 0;
}
