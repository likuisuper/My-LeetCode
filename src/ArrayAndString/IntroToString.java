package ArrayAndString;
import java.lang.String;
/*
比较函数
字符串有它自己的比较函数
然而，存在这样一个问题：我们是否可以用"=="来比较两个字符串吗？
这取决于我们所使用的语言是否支持运算符重载？
    如果答案是yes(例如C++)，可以用"=="来比较两个字符串
    如果答案是no(例如JAVA),可能无法使用"=="来比较两个字符串，当我们使用"=="时，它实际上会比较这两个对象是否是同一个对象

是否可变
不可变意味着字符串一旦被初始化，你就无法改变它的内容
    在某些语言（如 C ++）中，字符串是可变的。 也就是说，你可以像在数组中那样修改字符串。
    在其他一些语言（如  Java）中，字符串是不可变的
 */
public class IntroToString {
    public static void main(String[] args) {
        //初始化
        String s1="Hello";
        System.out.println("s1 is \""+s1+"\"");
        String s2=s1;
        System.out.println("s2 is another reference to s1.");
        String s3=new String(s1);
        System.out.println("s3 is a copy of s1.");
        //compare using "=="
        System.out.println("Compared by'==':");
        //因为字符串是不可变的，而且s1被绑定到“Hello world”
        System.out.println("s1 and \"Hello world\":"+(s1=="Hello world"));
        //为真，因为s1和s2是同一个对象的引用
        System.out.println("s1 and s2:"+(s1==s2));
        //false,因为s3被引用到另一个新的对象
        System.out.println("s1 and s3:"+(s1==s3));
        //compare using 'equals'
        System.out.println("Compared by 'equals'");
        System.out.println("s1 and \"Hello world\":"+s1.equals("Hello world"));
        System.out.println("s1 and s2:"+s1.equals(s2));
        System.out.println("s1 and s3:"+s1.equals(s3));
        //compare using 'compareTo"
        System.out.println("Compared by 'compareTo'");
        System.out.println("s1 and \"Hello world\":"+(s1.compareTo("Hello world")==0));
        System.out.println("s1 and s2:"+(s1.compareTo(s2)==0));
        System.out.println("s1 and s3:"+(s1.compareTo(s3)==0));
        //是否可变
        System.out.println();
        String[] s5={"Hello","World"};
        s5[1]=",";
        System.out.println(s5[1]);

        //额外操作
        System.out.println();
        String s8="Hello World";
        //连接
        s8+="!";
        System.out.println(s8);
        //find
        System.out.println("the position of first 'o' is:"+s8.indexOf('o'));
        System.out.println("the position of last 'o' is:"+s8.lastIndexOf('o'));
        //get substring
        System.out.println(s8.substring(6,11));//从6开始到10


        //不可变字符串无法被修改，哪怕只是修改其中一个字符，也必须创建一个新的字符串
        System.out.println();
        System.out.println("字符串连接");
        /*
        在 Java 中，由于字符串是不可变的，因此在连接时首先为新字符串分配足够的空间，
        复制旧字符串中的内容并附加到新字符串。
        下面这个算法的时间复杂度为：
        5+5*2+5*3+...+5*n=5*(1+2+3+...+n) 为o(n^2)
         */
        String s="";
        int n=100;
        for(int i=0;i<n;++i){
            s+="hello";
        }
        System.out.println(s);

        System.out.println();
        System.out.println("解决方案");
        //解决方案：如果希望字符串是可变的，这里有一些替代方案

        //1.将其转换为字符数组
        String s0="Hello World";
        char[] str=s0.toCharArray();
        str[5]=',';
        System.out.println(str);

        System.out.println();
        //2.如果经常必须连接字符串，最好使用其它的一些数据结构，比如StringBuilder,以下代码以o(n)复杂度运行
        int n1=100;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;++i){
            sb.append("hello");
        }
        String s9=sb.toString();
        System.out.println(s9);
    }
}
