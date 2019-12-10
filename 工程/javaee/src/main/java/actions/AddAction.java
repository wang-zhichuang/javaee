package actions;
public class AddAction {
    String num1,num2,info;
    public String execute(){
        try {
            int n1=Integer.parseInt(num1);
            int n2=Integer.parseInt(num2);
            info="结果为："+(n1+n2);
            return "success";
        } catch (NumberFormatException e) {
            info="请输入两个整数";
            return "input";
        }
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
