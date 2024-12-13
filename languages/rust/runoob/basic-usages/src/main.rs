fn main() {
    /**
     * # 打印输出
     * 使用index参数打印输出
     */
    let x = 5;
    println!("x is {0}", x);
    /**
     * # 变量 常量 数据类型
     * 变量分为可变变量、不可变变量，存在重影操作
     */
    let mut variable1 = 123;
    let variable2 = 456;
    let variable2 = false;
    const CONSTANT1: i32 = 21;

    /**
     * # 元组 结构体与枚举
     */
    // 枚举
    enum Color {
        Red,
        Green,
        Blue,
    }
    // 数据类型-元组
    let tup: (i32, f64, u8) = (500, 6.4, 1);
    let (x, y, z) = tup;
    println!("The value of x is: {}", x);
    struct Point {
        x: i32,
        y: i32,
        color: Color,
    }
    struct Point2 (i32, i32, Color);
    let point1 = Point { x: 5, y: 10, color: Color::Red };
    let point2 = Point2(1, 2, Color::Green);
    println!("{}, {}, {}", tup.0, point1.x, point2.0);

    /**
     * # 所有权
     * ownership borrowing reference
     * 所有权规则：1. Rust每个值都有一个变量，称为其所有者； 2. 一次只能有一个所有者； 3. 所有者不在程序运行范围时，值被删除。
     */
    let s1 = String::from("hello");
    let s2 = s1;
    // println!("{}", s1); // 编译报错，所有权已经转移给了s2，不能再使用s1
    let len = s2.len(); // 通过&实现借用
    println!("{}", len);

    /**
     * # 函数与流程控制
     * 函数表达式驱动，不用return，减少冗余，流程控制有if、loop、while、for
     */
    fn another_function(x: i32, y: i32) -> (i32, f64, u8) {
        (x + y, {
            let x = 3.14;
            x * x
        }, 2)
    }

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
    // 模式匹配
    //类似于switch，优于switch
    fn value_in_colors(color: Color) -> i32 {
        match color {
            Color::Red => 10,
            Color::Green => 20,
            Color::Blue => 30,
        }
    }


    /**
     * # 迭代器 Iterator
     * 惰性求值，链式调用
     */
    let v = vec![1, 2, 3];
    // iter 不可变引用迭代器 iter_nut 可变借用迭代器， into_iter 获取所有权迭代 par_iter 并行迭代器
    let mut iter = v.iter();
    // 常见迭代器方法有 map filter fold skip take enumerate...
    // 消耗性适配器有 collect sum product count等
    let squared_vec: Vec<i32> = v.iter().map(|x| x * x).collect();
    // for使用
    for &num in v.iter() {
        println!("{}", num);
    }


    /**
     * # 闭包 Closure
     * Fn: 不可变地借用 FnMut 可变借用 FnOnce 获取所有权，只能被调用一次
     */
    let add = |a: i32, b: i32| a + b;
    fn make_adder(x: i32) -> impl Fn(i32) -> i32 {
        move |y| x + y
    }

    fn closure_test() {
        let add_five = make_adder(5);
        println!("5 + 3 = {}", add_five(3)); // 输出: 5 + 3 = 8
    }

    /**
     * # (切片)类型 Slice
     * 切片类型是一种引用类型，可以引用集合中的一部分元素。
     */
    let s = String::from("broadcast");

    let part1 = &s[0..5];
    let part2 = &s[5..9];

    /**
     * # 错误处理
     * result option 两种
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

}
