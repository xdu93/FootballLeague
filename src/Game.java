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
        
    }

}
