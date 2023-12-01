public class Account {
    private int Banlance;
    private int Deposit;
    private int Withdraw;
    private int TransferAmount;
    private  int Money;//钞箱金额；
    private char Password;
    private char UserID;
 public Account(int Banlance,int Deposit,int Withdraw,int TransferAmount,char Password,char UserID,int Money)
    {
        this.Banlance=Banlance;
        this.Deposit=Deposit;
        this.Withdraw=Withdraw;
        this.TransferAmount=TransferAmount;
        this.Password=Password;
        this.UserID=UserID;
        this.Money=Money;
    }
    public int GetBanlance()
    {
        return Banlance;
    }
    public boolean Signin(char P)
    {
        //参数是密码
        //判断输入的密码与数据库内存的密码是否相同
    }
    public void DepositMoney(int d)
    {
        Money+=d;
        Banlance+=d;//参数是存款金额

    }
    public void WithdrawMoney(int w)
    {
        if((Banlance>=w)&&(Money>=w))
        {Banlance-=w;
        System.out.println("请取走您的钞票");}
        else if(Banlance<w) {
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
