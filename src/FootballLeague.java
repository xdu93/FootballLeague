public class FootballLeague {
    public static String[] listOfTeams = new String[4];
    public static int[] range = {1, 2, 3, 4};
    public static int [] leaguePoints = new int[4];

    public static void tableOfLeague(){
        System.out.println("Футбольная лига-1:");
        System.out.println(FootballLeague.range[0]+") "+FootballLeague.listOfTeams[0]+". Кол-во очков: "+FootballLeague.leaguePoints[0]);
        System.out.println(FootballLeague.range[1]+") "+FootballLeague.listOfTeams[1]+". Кол-во очков: "+FootballLeague.leaguePoints[1]);
        System.out.println(FootballLeague.range[2]+") "+FootballLeague.listOfTeams[2]+". Кол-во очков: "+FootballLeague.leaguePoints[2]);
        System.out.println(FootballLeague.range[3]+") "+FootballLeague.listOfTeams[3]+". Кол-во очков: "+FootballLeague.leaguePoints[3]);
    }

}
