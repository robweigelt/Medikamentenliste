package r.w;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimetableO {
    private String ID;
    private String Title;
    private String Surname;
    private String Name;
    private String Date;
    private String Time;

    private TimetableO(String ID, String Title, String Surname, String Name, String Date, String Time) {
        super();
        this.ID = ID;
        this.Title = Title;
        this.Surname = Surname;
        this.Name = Name;
        this.Date = Date;
        this.Time = Time;
    }

    private String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    private String getTitle()
    {
        return Title;
    }

    public void setTitle(String Title)
    {
        this.Title = Title;
    }

    private String getSurname()
    {
        return Surname;
    }

    public void setSurname(String Surname)
    {
        this.Surname = Surname;
    }

    private String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    private String getDate()
    {
        return Date;
    }

    public void setDate(String date)
    {
        Date = date;
    }

    private String getTime()
    {
        return Time;
    }

    public void setTime(String time)
    {
        Time = time;
    }

    public static List switcherTimeCategory(int n)
    {
        createTimetable();
        List<String> myList = new ArrayList<>();
        switch (n)
        {
            case 1:
                for (TimetableO t: TimetableO.Timetable)
                {
                    myList.add(t.getID());
                }
                break;

            case 2:
                for (TimetableO t : TimetableO.Timetable)
                {
                    myList.add(t.getTitle());
                }
                break;

            case 3:
                for (TimetableO t : TimetableO.Timetable)
                {
                    myList.add(t.getSurname());
                }
                break;

            case 4:
                for (TimetableO t : TimetableO.Timetable)
                {
                    myList.add(t.getName());
                }
                break;

            case 5:
                for (TimetableO t : TimetableO.Timetable)
                {
                    myList.add(t.getDate());
                }
                break;

            case 6:
                for (TimetableO t : TimetableO.Timetable) {
                    myList.add(t.getTime());
                }
                break;

            default:
                System.out.println("You Entered an invalid Number");

        }
        return myList;
    }

    @Override
    public String toString() {
        return "ID [ID=" + ID
                + ", Title=" + Title
                + ", Surname=" + Surname
                + ", Name=" + Name
                + ", Date=" + Date
                + ", Time=" + Time
                + "]";
    }

    private static List<TimetableO> Timetable = new ArrayList<>();
    private static final String Parser = ";";

    private static void createTimetable() {
        String neuDateipfad = Path.getPathofTerminbuchungen();

        BufferedReader CSVReader = null;
        try {
            CSVReader = new BufferedReader(new FileReader(neuDateipfad));


            String line ="";
            CSVReader.readLine();
            while ((line = CSVReader.readLine()) != null) {
                String[] TimeStringArray = line.split(Parser);


                TimetableO time0 = new TimetableO(
                        TimeStringArray[0],
                        TimeStringArray[1],
                        TimeStringArray[2],
                        TimeStringArray[3],
                        TimeStringArray[4],
                        TimeStringArray[5]
                );
                Timetable.add(time0);

            }

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                assert CSVReader != null;
                CSVReader.close();
            } catch (IOException ie) {
                System.out.println("Error occured while reading the file");
                ie.printStackTrace();

            }
        }
    }
}
