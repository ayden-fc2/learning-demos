#include <stdio.h>

// 声明外部变量
extern int d;
extern int f;

// 声明外部函数
void printExternVariables();

int main() {
    // 使用外部变量
    printf("d in main: %d\n", d);
    printf("f in main: %d\n", f);
    
    // 调用其他文件中定义的函数
    printExternVariables();
    
    return 0;
}

