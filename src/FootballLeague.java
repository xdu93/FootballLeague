public class FootballLeague {
    /*Класс FootballLeague (футбольная лига): имеет 4 массива из которых формируется турнирная таблица:
     1 - номер по порядку
     2 - Список команд
     3 - Название команд
     4 - Кол-во очков
     */
    public int[] range;
    public Team[] listOfTeams;
    public String[] listOfTeamsNames;
    public int [] leaguePoints;

    //Конструктор FootballLeague
    public FootballLeague(int[] range, Team[] listOfTeams, String[] listOfTeamsNames, int[] leaguePoints) {
        this.range = range;
        this.listOfTeams = listOfTeams;
        this.listOfTeamsNames = listOfTeamsNames;
        this.leaguePoints = leaguePoints;
    }

    //метод printTableOfLeague выводит на печать турнирную таблицу на данный момент
    public void printTableOfLeague(String str){
        System.out.println("______________");
        System.out.println(str);
        System.out.println("Футбольная лига-1:");

        for (int i = 0; i < listOfTeamsNames.length; i++) {
            System.out.println(range[i]+") "+listOfTeamsNames[i]+". Кол-во очков: "+leaguePoints[i]);
        }
        System.out.println("______________");
    }

    //метод заполняет турнирную таблицу текущими значениями
    public void fillTables() {
        //for (int i = 0; i < this.listOfTeams.length; i++) {
            //this.listOfTeamsNames[i] = this.listOfTeams[i].name;
       //}
        for (int i = 0; i < listOfTeamsNames.length; i++) {
            leaguePoints[i] = listOfTeams[i].points;
        }
    }

    /* метод Match(матч) для определения победителя в каждом матче.
        зависит от мотивации (случайное число от 1 до 4, на которое умножается power-сила изначально более слабого соперника)
     */
    public static void match(Team team1, Team team2) {
        int motivation = (int) ((Math.random()) * (4) + 1);
        int power1 = team1.power;
        int power2 = team2.power;

        if (team1.power < team2.power) team1.power *= motivation;
        else team2.power *= motivation;

        if (team1.power == team2.power) {
            System.out.println("Матч: " + team1.name + " vs " + team2.name + ". Результат: Ничья");
            team1.points++;
            team2.points++;
        } else if (team1.power > team2.power) {
            System.out.println("Матч: " + team1.name + " vs " + team2.name + ". Результат: Победитель " + team1.name);
            team1.points += 3;
        } else {
            System.out.println("Матч: " + team1.name + " vs " + team2.name + ". Результат: Победитель " + team2.name);
            team2.points += 3;
        }
        team1.power = power1;
        team2.power = power2;
    }

}
