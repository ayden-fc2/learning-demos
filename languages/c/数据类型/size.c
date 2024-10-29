#include <stdio.h>
#include <limits.h>
#include <float.h>

int main() {
    // 打印字符类型
    printf("char:\n");
    printf("大小: %zu byte\n", sizeof(char));
    printf("最小值: %d\n", CHAR_MIN);
    printf("最大值: %d\n", CHAR_MAX);
    
    // 打印短整型
    printf("\nshort:\n");
    printf("大小: %zu bytes\n", sizeof(short));
    printf("最小值: %d\n", SHRT_MIN);
    printf("最大值: %d\n", SHRT_MAX);
    
    // 打印整型
    printf("\nint:\n");
    printf("大小: %zu bytes\n", sizeof(int));
    printf("最小值: %d\n", INT_MIN);
    printf("最大值: %d\n", INT_MAX);
    
    // 打印长整型
    printf("\nlong:\n");
    printf("大小: %zu bytes\n", sizeof(long));
    printf("最小值: %ld\n", LONG_MIN);
    printf("最大值: %ld\n", LONG_MAX);
    
    // 打印长长整型
    printf("\nlong long:\n");
    printf("大小: %zu bytes\n", sizeof(long long));
    printf("最小值: %lld\n", LLONG_MIN);
    printf("最大值: %lld\n", LLONG_MAX);
    
    // 打印浮点型
    printf("\nfloat:\n");
    printf("大小: %zu bytes\n", sizeof(float));
    printf("最小值: %e\n", FLT_MIN);
    printf("最大值: %e\n", FLT_MAX);
    
    // 打印双精度浮点型
    printf("\ndouble:\n");
    printf("大小: %zu bytes\n", sizeof(double));
    printf("最小值: %e\n", DBL_MIN);
    printf("最大值: %e\n", DBL_MAX);
    
    // 打印长双精度浮点型
    printf("\nlldouble:\n");
    printf("大小: %zu bytes\n", sizeof(long double));
    printf("最小值: %Le\n", LDBL_MIN);
    printf("最大值: %Le\n", LDBL_MAX);

    return 0;
}
