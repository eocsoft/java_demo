package net.dao;

public class User
{
    private int UID;

    private String USER_NAME;

    private String PASSWORD;

    private int LAST_TIME;

    public int getUID ()
    {
        return UID;
    }

    public void setUID (int UID)
    {
        this.UID = UID;
    }

    public String getUSER_NAME ()
    {
        return USER_NAME;
    }

    public void setUSER_NAME (String USER_NAME)
    {
        this.USER_NAME = USER_NAME;
    }

    public String getPASSWORD ()
    {
        return PASSWORD;
    }

    public void setPASSWORD (String PASSWORD)
    {
        this.PASSWORD = PASSWORD;
    }

    public int getLAST_TIME ()
    {
        return LAST_TIME;
    }

    public void setLAST_TIME (int LAST_TIME)
    {
        this.LAST_TIME = LAST_TIME;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [UID = "+UID+", USER_NAME = "+USER_NAME+", PASSWORD = "+PASSWORD+", LAST_TIME = "+LAST_TIME+"]";
    }
}
