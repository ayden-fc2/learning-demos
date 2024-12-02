fn main() {
    /*
     * 打印输出
     */
    let x = 5;
    println!("x is {0}", x);
    /*
     * 变量常量函数
     */
    // 可变变量、不可变变量、常量
    let mut variable1 = 123;
    let variable2 = 456;
    const CONSTANT1: i32 = add(123, 456);
    // 函数
    const fn add(a: i32, b: i32) -> i32 {
        a + b
    }
    /*
    流程控制
     */
    // 循环与if
    loop {
        variable1 += 100;
        if variable1 > CONSTANT1 {
            break;
        } else {
            println!("{}", variable2);
        }
    }
    while variable1 > CONSTANT1 {
        println!("{}", variable1);
        variable1 -= 5;
    }
    for x in 0..10 {
        println!("{}", x);
    }
    /*
    所有权
     */
    // 所有权 ownership borrowing reference
    let s1 = String::from("hello");
    let s2 = s1;
    // println!("{}", s1); // 编译报错，所有权已经转移给了s2，不能再使用s1
    let len = &s2.len(); // 通过&实现借用
    println!("{}", len);
    /*
    结构体与枚举
     */
    enum Color {
        Red,
        Green,
        Blue,
    }
    struct Point {
        x: i32,
        y: i32,
        color: Color,
    }
    let origin = Point { x: 0, y: 0, color: Color::Red };
    println!("({}, {})", origin.x, origin.y);
    /*
    模式匹配
     */
    fn value_in_colors(color: Color) -> i32 {
        match color {
            Color::Red => 10,
            Color::Green => 20,
            Color::Blue => 30,
        }
    }
    /*
    错误处理
     */
    fn divide(a: i32, b: i32) -> Result<i32, String>{
        if b == 0 {
            Err(String::from("division by zero"))
        }else {
            Ok(a / b)
        }
    }
    fn divide_option(a: i32, b:i32) -> Option<i32>{
        if b == 0 {
            None
        } else {
            Some(a / b)
        }
    }
    /*
    重影
     */
    let mut s = "123";
    // s = s.len(); 变量报错
    let s1 = "123";
    let s1 = s1.len(); // 重影不报错
}
