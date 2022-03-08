public class Game {
    public static void main(String[] args) {

        Team team1 = new Team("Динамо", 20);
        Team team2 = new Team("Спартак", 20);
        Team team3 = new Team("Арсенал", 20);
        Team team4 = new Team("Зенит", 20);

        FootballLeague leagueOne = new FootballLeague(new int[]{1 ,2, 3, 4},
                                                    new Team[]{team1, team2, team3, team4},
                                                    new String[]{team1.name, team2.name, team3.name, team4.name},
                                                            new int[]{0, 0, 0, 0});

        leagueOne.fillTables();
        leagueOne.printTableOfLeague("Старт турнира");
        playGame(leagueOne);
        leagueOne.fillTables();
        leagueOne.printTableOfLeague("Конец турнира");
    }

    //Метод для проведения матчей между всеми командами, каждая команда играет с каждой один раз
    public static void playGame(FootballLeague league){
        for (int i = 0; i < league.listOfTeams.length; i++) {
            for (int j = i+1; j < league.listOfTeams.length; j++) {
                league.match(league.listOfTeams[i],league.listOfTeams[j]);
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
