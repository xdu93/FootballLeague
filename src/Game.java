public class Game {
    public static void main(String[] args) {

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        FootballLeague.listOfTeams[0] = team1;
        FootballLeague.listOfTeams[1] = team2;
        FootballLeague.listOfTeams[2] = team3;
        FootballLeague.listOfTeams[3] = team4;

        team1.name = "Динамо";
        team2.name = "Спартак";
        team3.name = "Арсенал";
        team4.name = "Зенит";

        team1.power = 20;
        team2.power = 30;
        team3.power = 55;
        team4.power = 25;

        FootballLeague.fillTables();
        FootballLeague.printTableOfLeague("Старт турнира");
        playGame();
        FootballLeague.fillTables();
        FootballLeague.printTableOfLeague("Конец турнира");
        winner();
    }

    //Метод для проведения матчей между всеми командами, каждая команда играет с каждой один раз
    public static void playGame(){
        for (int i = 0; i < FootballLeague.listOfTeams.length; i++) {
            for (int j = i+1; j < FootballLeague.listOfTeams.length; j++) {
                FootballLeague.match(FootballLeague.listOfTeams[i],FootballLeague.listOfTeams[j]);
            }
        }
    }

    public static void winner(){
        Team teamWinner = FootballLeague.listOfTeams[0];
        int pointOfWinner = FootballLeague.leaguePoints[0];

        for (int i = 1; i < FootballLeague.leaguePoints.length; i++) {
            if (pointOfWinner < FootballLeague.leaguePoints[i]){
                pointOfWinner = FootballLeague.leaguePoints[i];
                teamWinner = FootballLeague.listOfTeams[i];
            }
        }

        //жребий
        if (pointOfWinner == 6){
            System.out.println("У нескольких команд по 6 очков. Необходима жеребьёвка, для определения победителя.");
            int count = 0;
            for (int i = 0; i < FootballLeague.listOfTeams.length; i++) {
                if (FootballLeague.leaguePoints[i] == 6){
                    count++;
                }
            }
            Team[] winners = new Team[count];
            int random = (int) ((Math.random()) * (count)+0);
            for (int i = 0; i < FootballLeague.listOfTeams.length; i++) {
                if (FootballLeague.leaguePoints[i] == 6){
                    winners[count-1] = FootballLeague.listOfTeams[i];
                    count--;
                }
            }
            System.out.println("Победитель: "+winners[random].name);
        } else {
            System.out.println("Победитель: "+teamWinner.name);
        }
    }
}
