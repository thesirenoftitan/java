import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class FootballClubv2 {

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();
        
        populatePlayers(players);
        
        Scanner input = new Scanner(System.in);

        System.out.println("Please select an option:");
        System.out.println("1. Add a new player");
        System.out.println("2. Display all players");
        System.out.println("3. Create team");
        System.out.println("4. Create a random team");
        System.out.println("5. Display positions total");
        System.out.println("6. Sort by APT");
        System.out.println("7. Highest APT");
        System.out.println("8. Lowest AVG");
        System.out.println("9. Exit");

        int option = input.nextInt();

        switch (option) {
            case 1:
                addNewPlayer(players);
                break;
            case 2:
                displayAllPlayers(players);
                break;
            case 3:
                createTeam(players);
                break;
            case 4:
                createRandomTeam(players);
                break;
            case 5:
                displayPositionsTotal(players);
                break;
            case 6:
                sortByAPT(players);
                break;
            case 7:
                displayHighestAPT(players);
                break;
            case 8:
                displayLowestAVG(players);
                break;
            case 9:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option selected. Please try again.");
                break;
        }

       
    }
    
    public static void populatePlayers(ArrayList<Player> players) {
        
        players.add(new Player(1, "Daniel", "Scott", 79, 92, "Scotland", "Attacker"));
        players.add(new Player(2, "Ali", "Aslam", 98, 94, "Northern Ireland", "Midfielder"));
        players.add(new Player(3, "Oliver", "Barker", 89, 95, "England", "Defender"));
        players.add(new Player(4, "Jordan", "Robinson", 45, 89, "Wales", "Attacker"));
        players.add(new Player(5, "Steven", "Walker", 88, 87, "Wales", "Midfielder"));
        players.add(new Player(6, "Alfie", "Loy", 85, 79, "Wales", "Attacker"));
        players.add(new Player(7, "Rashid", "Bhatti", 90, 86, "England", "Midfielder"));
        players.add(new Player(8, "Thomas", "Taylor", 97, 85, "England", "Defender"));
        players.add(new Player(9, "Theo", "Dolan", 87, 82, "Scotland", "Attacker"));
        players.add(new Player(10, "Finley", "Cross", 95, 83, "Northern Ireland", "Midfielder"));
        players.add(new Player(11, "Joshua", "Mills", 92, 71, "Scotland", "Attacker"));
        players.add(new Player(12, "Leander", "Moore", 91, 72, "Northern Ireland", "Midfielder"));
        players.add(new Player(13, "Isaac", "Johnson", 76, 77, "England", "Defender"));
        players.add(new Player(14, "William", "Adams", 78, 78, "England", "Midfielder"));
        players.add(new Player(15, "Jacob", "Stone", 77, 79, "Wales", "Midfielder"));
        players.add(new Player(16, "James", "Chaffey", 93, 70, "Wales", "Attacker"));
        players.add(new Player(17, "Lucas", "Saunders", 68, 69, "Wales", "Attacker"));
        players.add(new Player(18, "Alexander", "Daly", 43, 67, "England", "Midfielder"));
        players.add(new Player(19, "Arlo", "Gilchrist", 50, 65, "England", "Attacker"));


    }

    public static void addNewPlayer(ArrayList<Player> players) {
        Scanner input = new Scanner(System.in);
    
        System.out.println("Enter the details of the new player:");
        System.out.print("Player ID: ");
        int id = input.nextInt();
        System.out.print("First Name: ");
        String firstName = input.next();
        System.out.print("Last Name: ");
        String lastName = input.next();
        System.out.print("APt: ");
        int attackRating = input.nextInt();
        System.out.print("SET: ");
        int defenseRating = input.nextInt();
        System.out.print("Nationality: ");
        String nationality = input.next();
        System.out.print("Position: ");
        String position = input.next();
    
        Player newPlayer = new Player(id, firstName, lastName, attackRating, defenseRating, nationality, position);
        players.add(newPlayer);
        System.out.println("New player added successfully.");
    }

    public static void displayAllPlayers(ArrayList<Player> players) {
        System.out.println("List of all players:");
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }

    public static void createTeam(ArrayList<Player> players) {
        Scanner input = new Scanner(System.in);
    
        System.out.println("Enter the required number of defenders: ");
        int numDefenders = input.nextInt();
    
        System.out.println("Enter the required number of midfielders: ");
        int numMidfielders = input.nextInt();
    
        System.out.println("Enter the required number of attackers: ");
        int numAttackers = input.nextInt();
    
        ArrayList<Player> defenders = new ArrayList<>();
        ArrayList<Player> midfielders = new ArrayList<>();
        ArrayList<Player> attackers = new ArrayList<>();
    
        // Iterate over all players and add them to the appropriate list based on their position
        for (Player player : players) {
            String position = player.getPosition();
            switch (position) {
                case "Defender":
                    defenders.add(player);
                    break;
                case "Midfielder":
                    midfielders.add(player);
                    break;
                case "Attacker":
                    attackers.add(player);
                    break;
            }
        }
    
        // Sort the players in each list based on their SET score (highest to lowest)
        defenders.sort(Comparator.comparing(Player::getSET).reversed());
        midfielders.sort(Comparator.comparing(Player::getSET).reversed());
        attackers.sort(Comparator.comparing(Player::getSET).reversed());
    
        ArrayList<Player> team = new ArrayList<>();
    
        // Add the required number of defenders to the team
        for (int i = 0; i < numDefenders; i++) {
            if (defenders.size() > i) {
                team.add(defenders.get(i));
            } else {
                System.out.println("Not enough defenders to fill the required number.");
                break;
            }
        }
    
        // Add the required number of midfielders to the team
        for (int i = 0; i < numMidfielders; i++) {
            if (midfielders.size() > i) {
                team.add(midfielders.get(i));
            } else {
                System.out.println("Not enough midfielders to fill the required number.");
                break;
            }
        }
    
        // Add the required number of attackers to the team
        for (int i = 0; i < numAttackers; i++) {
            if (attackers.size() > i) {
                team.add(attackers.get(i));
            } else {
                System.out.println("Not enough attackers to fill the required number.");
                break;
            }
        }
    
        System.out.println("The selected team is: ");
        for (Player player : team) {
            System.out.println(player.getPlayer());
        }
    }
    

    public static void createRandomTeam(ArrayList<Player> players) {
        Scanner input = new Scanner(System.in);
    
        System.out.println("Enter the required size of team: ");
        int randomTeamSize = input.nextInt();
    
        ArrayList<Player> randomTeam = new ArrayList<>();
    
        // Shuffle the player list to randomize the selection
        Collections.shuffle(players);
    
        // Loop through the shuffled players and add them to the team until the desired size is reached
        int i = 0;
        while (randomTeam.size() < randomTeamSize && i < players.size()) {
            Player player = players.get(i);
            int playersCount = countPlayers(randomTeam, player.getPosition());
            int playersLimit = 0;
            if (player.getPosition().equals("Defender")) {
                playersLimit = 1;
            } else if (player.getPosition().equals("Midfielder")) {
                playersLimit = 2;
            } else if (player.getPosition().equals("Attacker")) {
                playersLimit = 7;
            }
            if (playersCount < playersLimit) {
                randomTeam.add(player);
            }
            i++;
        }
        
    
        // Print the selected players
        System.out.println("Random team selected:");
        for (Player player : randomTeam) {
            System.out.println(player.getPlayer());
        }
    }

        // Helper method to count the number of players in the team with the given position
        public static int countPlayers(ArrayList<Player> team, String position) {
            int count = 0;
            for (Player player : team) {
                if (player.getPosition().equals(position)) {
                    count++;
                }
            }
            return count;
        }

        public static void displayPositionsTotal(ArrayList<Player> players) {
            HashMap<String, Integer> positionCount = new HashMap<>();
            
            // Loop through the players and increment the count for each position
            for (Player player : players) {
                String position = player.getPosition();
                int count = positionCount.getOrDefault(position, 0);
                positionCount.put(position, count + 1);
            }
            
            // Print the position counts
            System.out.println("ID\tPosition\tCount");
            int id = 1;
            for (String position : positionCount.keySet()) {
                int count = positionCount.get(position);
                System.out.println(id + "\t" + position + "\t\t" + count);
                id++;
            }
        }
        
        public static void sortByAPT(ArrayList<Player> players) {
            Collections.sort(players, new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    return Integer.compare(p1.getAPT(), p2.getAPT());
                }
            });
        
            // Print the sorted list
            for (Player player : players) {
                System.out.println(player.getPlayer());
            }
        }

        public static void displayHighestAPT(ArrayList<Player> players) {
            Player highestAPTPlayer = players.get(0);
            for (Player player : players) {
                if (player.getAPT() > highestAPTPlayer.getAPT()) {
                    highestAPTPlayer = player;
                }
            }
            System.out.println("Player with the highest APT score:");
            System.out.println(highestAPTPlayer.getPlayer());
        }
        
        public static void displayLowestAVG(ArrayList<Player> players) {
            Player lowestAvgPlayer = players.get(0);
            for (Player player : players) {
                if (player.getAverageScore() < lowestAvgPlayer.getAverageScore()) {
                    lowestAvgPlayer = player;
                }
            }
            System.out.println("Player with the lowest average score:");
            System.out.println(lowestAvgPlayer.getPlayer());
        }
        

}