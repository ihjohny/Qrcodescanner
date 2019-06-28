package com.ice.shamim.qrcodescanner;

public class Student
{
    private String student_session;

    private String student_id;

    private Student_user student_user;

    public String getStudent_session ()
    {
        return student_session;
    }

    public void setStudent_session (String student_session)
    {
        this.student_session = student_session;
    }

    public String getStudent_id ()
    {
        return student_id;
    }

    public void setStudent_id (String student_id)
    {
        this.student_id = student_id;
    }

    public Student_user getStudent_user ()
    {
        return student_user;
    }

    public void setStudent_user (Student_user student_user)
    {
        this.student_user = student_user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [student_session = "+student_session+", student_id = "+student_id+", student_user = "+student_user+"]";
    }
}

