package Theorie.Kap6._5_Laptop;

public class Main {
    public static void main(String[] args)
    {
        new Laptop(
                "12837"
                ,"Asus"
                ,"Flex7"
                ,1599.99
                ,new Gehaeuse(
                        "123125"
                        , "BeQuiet"
                        , "FlowMax"
                        , "Schwarz"
                        , "Metall"
                        , 120
                        ,120
                        ,50
                )
                ,new Mainboard(
                        "912873a"
                        ,"Asus"
                        ,"ROG L6"
                        ,4
                        , new Prozessor()
                        , new RAM()
                )
                ,new Bildschirm(
                        "1920x1080"
                )
                , new Festplatte(
                        "1245512223"
                        ,"Western Digital"
                        ,"Platinum Drive"
                )
        );
    }
}