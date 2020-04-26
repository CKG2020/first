import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Ognl1 {
    public static void main(String[] args) {

        try {
//            创建context对象
            OgnlContext context = new OgnlContext();
//            利用context来获取root对象
            Object root = context.getRoot();
//            Ognl中的静态方法getValue(expression, context, root, resultType)可以用来获取数据
            Object value = Ognl.getValue("'helloworld'.length()", context, root);  //expression就是方法表达式
            System.out.println(value.toString());
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }
}