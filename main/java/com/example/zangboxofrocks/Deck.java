package com.example.zangboxofrocks;
public class Deck {
    private int count;
    //TO DO: make the length that matches your number of cards
    private Card data[] = new Card[60];
    public Deck() {
        shuffle();
    }
    public void shuffle(){
        //TO DO: Make an array for each instance variable. A card's pieces are all in the same index
        String[] questions = {
                "In the 1990s, how many of the TIME magazine's Man of Year covers featured two or more people?",
                "How many raindrops are less than half a millimeter in diameter?",
                "How many of these countries border the Mediterranean Sea: Greece, Libya,Portugal?",
                "How many categories of the menswear increased in price between 2013 and 2016?",
                "How many mammals have thicker fur than sea otters?",
                "How many inches over five feet tall is Lady Gaga?",
                "Of the six members of quirky British comedy group Monty Python, how many were Americans?",
                "How many NBA b-ballers have played for both champions finals teams in the same season?",
                "How many ballet dancers are performing in a pas de deux?",
                "How many people have died from being hit by a penny dropped from the Empire State Building?",
                "How many comic books have sold for more than $3 million at auction?",
                "FAA regulations require how many flight attendants for every 50 passengers on an aircraft?",
                "How many colors coat the black licorice centers of Good & Plenty candies?",
                "How many of U.S. state abbreviations feature two vowels?",
                "How many six noble gases do not end in \"on\"",
                "How many times has Canada hosted the Winter Olympics?",
                "How many U.S. national monuments have been dedicated to honor the LGBT community?",
                "How many of the 54 countries in Africa have a one-syllable name?",
                "How many of the episode titles on Tv's Friends do not begin with these two words, \"The One.\"",
                "How many teams did Packers legend Vince Lombardi coach after he left Green Bay in 1969?",
                "How many NFL teams have played the Super Bowl on their own home field?",
                "How many words in the English language rhyme with the word \"silver\"?",
                "About how many months did it take Erno Rubik to solve his famous colorful cube for the first time?",
                "In a traditional game of Magic-The Gathering, how many lands does each player start with on the table?",
                "How many characters in the Harry Potter series are able to survive the powerful curse?",
                "How many species of birds can outrun an ostrich?",
                "Of the four blood types, how many can donate only to the exact same blood type?",
                "How many South American countries have hosted the Summer Olympic Games?",
                "How many earthworms are formed when you divide one in half?",
                "As of 2015, how many countries are more charitable than United States?",
                "How many eggs does a bay lay in each brood?",
                "How many albums by Miles Davis are in the list of top ten best-selling jazz of all time?",
                "In the nursery rhyme, how many bones were in Old Mother Hubbard's cupboard?",
                "How many paintings did Vincent van Gogh sell during his lifetime?",
                "How many properties in the traditional game of Monopoly are not named after places in Atlantic City, New Jersey?",
                "How many of the four ghost Pac-Man have names that do not rhyme with the others?",
                "How many races did the celebrated thoroughbred man o' War lose?",
                "How many continents cover all four hemispheres: North, South, East, and West?",
                "How many Major League Baseball pitchers have hit a grand slam in a World Series?",
                "How many days before his last original Peanuts cartoon was published did Charles Schulz die?",
                "How many native U.S. lizards are larger than the Gila Monster?",
                "For how many Westerns was director John Ford awarded an Oscar?",
                "How many flavors are in those \"mystery flavor\" Dum Dums lollipops with the question marks on their wrappers?",
                "How many members of the rock band U2 have been replaced since their 1978 formation?",
                "What is the letter value of a blank tile in a Scrabble game?",
                "In the Olympic five-ring logo, how many rings does the red one touch?",
                "How many dollars did an adult pay for an all-day ticket on Disneyland's opening day in 1955?",
                "How many of these edibles are not classified as fruits butternut squash,eggplant,beans,cucumbers?",
                "As of 2016, how many FIFA World Cup football titles has England won?",
                "Beside chocolate, how many flavors were included in the original 3 Musketeers candy bars?",
                "According to a 1961 Life Magazine article, how many James Bond novels novels made it to President John F. Kennedy's Ten-Favorite-Books list?",
                "How many aces were in Wild Bill Hickok's poker hand when he was gunned down in 1876 in Deadwood, South Dakota?",
                "How many U.S. state capitals do not have a McDonald's?",
                "How many current Major League Baseball teams have never played in the World Series?",
                "How many times was Adolf Hitler nominated for the Nobel Peace Prize?",
                "How many of these musical stars have won Academy Awards: Adele, Katy Perry, Justin Timberlake?",
                "How many heavyweight title bouts did Muhammad Ali fight using his given name Casaius Clay?",
                "How many grand slams hve been hit during MLB All-Star game?",
                "In tennis, if the score is deuce, how many consecutive points do you need to win the game?",
                "In how many films did Alan Rickman appear after Alica Through the Looking Glass?"
        };

        String[] ex = {
                "In 1998, impeached POTUS Bill Clinton and his accuser Ken Starr; In 1993 it was peacemakers de Klerk, Mandels,Rabin, and Arafat.",
                "The National Weather Service says size does matter; undersized raindrops are called drizzles, not drops.",
                "Only Greece and Libya share a Mediterranean shoreline; Portugal borders the Atlantic",
                "In fact, underwear was the only clothing whose cost didn't go down for guys during that period.",
                "A sea otter can have as many as one million hairs per square inch on part of its body.",
                "Those 18-inch-high platform shoes just make her look taller?",
                "Only Terry Gillian. Brits are John Cleese, Micheal Palin, Graham Chapman, Eric Idle, and Terry Jones.",
                "Anderson Varejao started 2015-2016 season with the Cleveland Cavaliers, and ended it with the Golden State Warriors.",
                "The phrase means \"steps for two\" The Sugar Plum Fairy and her prince in The Nutcracker do a pas de deux, a tres bien one.",
                "TV's Mythbusters tested this out and proved that a penny dropped from that height cannot gain the necessary velocity.",
                "The 1938 Action Comics #1 sold on eBay in 2014 for $3,207,852, it was the debut of Superman!",
                "That's also the average ratio of restrooms to passengers",
                "The pink and white candies, the oldest branded candy in the U.S. were first made in 1893.",
                "Only the Hawkeye State, Iowa, can make the claim with the abbreviation IA.",
                "Only helium, Neon, xenon, argon, krypton, and radon all have the same two letter ending.",
                "Vancouver in 2010, and Calgary in 1988; Montreal hosted the Summer Olympics in 1976.",
                "The Stonewall National Monument in New York City, the site of 1969 LGBT uprising, was designated by President Obama in 2016.",
                "Chad is the one. With a population of 11.8 million people, it's the fifth largest country in Africa.",
                "The first episode is titled \"The Pilot\", and the final a two-parter, is called \"The Last One.\"",
                "Lombardi led the Washington Redskins to their first winning record in 14 years.",
                "In 50 Super Bowls as of 2016, no team has ever played game at home",
                "It joins the group that includes \"orange\",\"month\",\"bulb\",and \"purple.\"",
                "And behold, the twisty-turney work of art turned into a blockbuster game",
                "During the game, players may play land from their hand in order to generate mana for spells, creatures, and artifacts",
                "Only Harry and Voldemort have the ability to escape the deadly spell's effects",
                "It's the fastest-running bird, and the speediest two-legged animal in the world.",
                "Type AB can donate only to other AB's but can receive from all four blood types",
                "In 2016, Brazil's Summer Games were the first Olympic Games in the events 120-year history to be held in South America",
                "Only the front section lives on (if it's lucky), and the lost body part at least partially grows back.",
                "Myanmar (formerly Burma) is more giving; Buddhism emphasizes charitable acts.",
                "Bats are mammals, not birds they give birth to live young. A female bat has one baby, or pup, at a time.",
                "His 1959 album Kind of Blue placed #1, and his Bitches Brew from 1970 is #9",
                "She went to the cupboard to get her dog a treat, but when she got there \"the cupboard was bare\"",
                "He sold Red Vineyard to his brother.",
                "There's no Marvin Gardens in Atlantic City, although Marven Gardens (with an \"e\") is located in nearby Margate City.",
                "Clyde, the orange ghost. is the one; the others are Blinky, Pinky, and Inky.",
                "The chestnut colt won 20 of his 21 races, losing only to a horse appropriately named Upeet in 1919.",
                "Africa, therefore, is also the only continent with land on both the prime meridian and equator",
                "Dave McNelly of the Baltimore Orioles crushed it during game three of the 1970 series against Cincinnati.",
                "Schulz died in 2000, 50 years after the first Peanuts comic strip was published.",
                "The venomous lizard can grow up to two feet long, making it biggest and baddest in America",
                "He won four Oscars, but none for cowboy fare: The informer, The Grapes of Wrath, How Green Was My Valley, and The Quiet Man",
                "They're a mixture of the two flavors that combine when one batch ends and the next batch begins.",
                "All four members are still rockin' on",
                "There are only two in a game and they can represent any letter.",
                "The red ring is in the first row on the far right and only touches the green ring.",
                "Kids got in for 50 cents.",
                "Avocado, zucchini, and pea pods are also considered fruits, not veggies.",
                "England, the inventor of the game called soccer in the U.S., defeated West Germany in 1966 to win its only title.",
                "The original snack included three pieces per pack: vanilla, chocolate, and strawberry.",
                "It was From Russia With Love and it was the only book of fiction on the list.",
                "There were two black aces, two black eights, and the fifth card unknown in what is now called the Dead Man's Hand.",
                "Montpelier, Vermont, likes to keep things local. You won't find a Burger King there, either.",
                "Though they've both played in championship series, neither the Seattle Mariners nor the Washington Nationals have gone any further",
                "In 1939, as a satiric gesture, an antifascist Swedish politician backed the Fuhrer, but later withdrew the nomination.",
                "Adele scored the 2013 Oscar for best original song, for \"Skyfall\"",
                "The Louisville Lip was still called Clay when he fought Sonny Liston in 1964 and won the title",
                "During the 50th anniversary game in 1983, Fred Lynn crushed it in the third inning assuring a win for the American League",
                "\"Deuce\" is when each player has scored three points; the next point is called \"advantage\", and the winning point is \"game\"",
                "Rickman, who died in January of 2016, voiced the Blue Caterpillar in the Wonderland, which was released in May of that year."
        };

        int [] answer = {
                2,0,2,1,0,1,1,1,2,0,1,1,
                2,1,1,2,1,1,2,1,0,0,1,0,
                2,0,1,1,1,1,0,2,0,1,1,1,
                1,1,1,1,0,0,2,0,0,1,1,0,
                1,2,1,2,1,2,1,1,1,1,2,0,
        };

        //TO DO: Randomize the order of the arrays
        for (int i = 0; i < 100; i++) {
            int r1 = (int) (Math.random() * questions.length);
            int r2 = (int) (Math.random() * questions.length);
            String temp = questions[r1];
            questions[r1] = questions[r2];
            questions[r2] = temp;

            int temp1 = answer[r1];
            answer[r1] = answer[r2];
            answer[r2] = temp1;

            String temp2 = ex[r1];
            ex[r1] = ex[r2];
            ex[r2] = temp2;
        }
        clear();
        //TO DO: push all (now in random order) into the Deck
        for (int i = 0; i < questions.length; i++) {
            Card c = new Card(questions[i], answer[i], ex[i]);
            push(c);
        }
    }
    public void push(Card addMe) {
        data[count] = addMe;
        count++;
    }
    public Card pop() {
        count--;
        return data[count];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public void clear() {
        count = 0;
    }
}