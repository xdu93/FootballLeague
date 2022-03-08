public class Game {
    public static void main(String[] args) {

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        team1.name = "Динамо";
        team2.name = "Спартак";
        team3.name = "Арсенал";
        team4.name = "Зенит";

        team1.power = 20;
        team2.power = 30;
        team3.power = 55;
        team4.power = 25;

        FootballLeague.listOfTeams[0] = team1.name;
        FootballLeague.listOfTeams[1] = team2.name;
        FootballLeague.listOfTeams[2] = team3.name;
        FootballLeague.listOfTeams[3] = team4.name;

        System.out.println("______________");
        System.out.println("Старт турнира");
        FootballLeague.tableOfLeague();

        System.out.println("________________");
        System.out.println("Матчи стартовали");
        match(team1, team2);
        match(team1, team3);
        match(team1, team4);
        match(team2, team3);
        match(team2, team4);
        match(team3, team4);

        FootballLeague.leaguePoints[0] = team1.points;
        FootballLeague.leaguePoints[1] = team2.points;
        FootballLeague.leaguePoints[2] = team3.points;
        FootballLeague.leaguePoints[3] = team4.points;

        System.out.println("______________");
        System.out.println("Конец турнира");
        FootballLeague.tableOfLeague();

    }

    public static void match(Team team1, Team team2) {
        int motivation = (int) ((Math.random()) * (4) + 1);
        int power1 = team1.power;
        int power2 = team2.power;

        if (team1.power < team2.power) team1.power *= motivation;
        else team2.power *= motivation;
        //System.out.println(motivation+","+ team1.power +", " + team2.power);

        if (team1.power == team2.power) {
            System.out.println("Матч: " + team1.name + " vs " + team2.name + " Результат: Ничья");
            team1.points++;
            team2.points++;
        } else if (team1.power > team2.power) {
            System.out.println("Матч: " + team1.name + " vs " + team2.name + " Результат: Победитель " + team1.name);
            team1.points += 3;
        } else {
            System.out.println("Матч: " + team1.name + " vs " + team2.name + " Результат: Победитель " + team2.name);
            team2.points += 3;
        }
        team1.power = power1;
        team2.power = power2;
    }
    
    public static void winner(){
        
    }

}
