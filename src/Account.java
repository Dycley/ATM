public class Account {
    private int banlance;
    private int deposit;
    private int withdraw;
    private int transferAmount;
    private  int money;//钞箱金额；
    private char password;
    private char cardID;
    public Account(int banlance,int deposit,int withdraw,int transferAmount,char password,char cardID,int money)
    {
        this.banlance=banlance;
        this.deposit=deposit;
        this.withdraw=withdraw;
        this.transferAmount=transferAmount;
        this.password=password;
        this.cardID =cardID;
        this.money=money;
    }
    public int getBanlance()
    {
        return banlance;
    }
    public boolean Signin(char P)
    {
        //参数是密码
        //判断输入的密码与数据库内存的密码是否相同
        return false;
    }
    public void DepositMoney(int d)
    {
        money+=d;
        banlance+=d;//参数是存款金额

    }
    public void WithdrawMoney(int w)
    {
        if((banlance>=w)&&(money>=w))
        {banlance-=w;
        System.out.println("请取走您的钞票");}
        else if(banlance<w) {
            System.out.println("余额不足，取款失败");
        }
        else System.out.println("钞箱钞票不足，取款失败");
    }
    public void TransferMoney(char i1,char i2,int m)//i是转账账户,m是转账金额
    {
        //判断两次输入账户id是否一致，判断余额是否大于转账金额，转账成功后，对两个账户信息进行修改
    }
    public void Inquire()
    {
        //查询账户余额信息或者交易明细
    }
    public void ChangePassword(char p1,char p2){
     //判断两次密码输入是否一致
        //若一致，则修改账户密码信息
    }
}
