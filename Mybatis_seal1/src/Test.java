import java.text.SimpleDateFormat;


import bean.XiaoFang;


public class Test {
public static void main(String[] args) {
	XiaoFangDao xiaoFang =new XiaoFangDao();
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	xiaoFang.queryXiaoFangList(new XiaoFang("后视镜",""));
}
}
