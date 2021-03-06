package ie.cct.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ie.cct.cli.CLI;
import ie.cct.model.Animal;
import ie.cct.model.Bird;
import ie.cct.model.Cat;
import ie.cct.model.Dog;
import ie.cct.model.Employee;
import ie.cct.model.Horse;
import ie.cct.model.ITSpecialist;
import ie.cct.model.Nurse;
import ie.cct.model.Rabbit;
import ie.cct.model.Receptionist;
import ie.cct.model.Task;
import ie.cct.model.TraineeVet;
import ie.cct.model.Treatment;
import ie.cct.model.Veterinarian;

/**
 * @author Manoel Vitor Nascimento Lopes
 * @college CCT - College
 * @studentNumber 2019286
 * @gitHub https://github.com/manoellvitor/vetClinicCA
 *
 */
public class Helper {
	// List of Animal to hold the objects of each kind of animals
	List<Animal> animals = new LinkedList<Animal>();
	// List of Employee to hold the objects of each kind of staff
	List<Employee> employees = new LinkedList<Employee>();
	// List of Tasks
	List<Task> tasks = new LinkedList<Task>();
	// List of Animals for treatment and the respective veterinarian
	List<Treatment> treatments = new LinkedList<Treatment>();
	// List of Veterinarians
	List<Employee> vets = new LinkedList<Employee>();

	public Helper() {
		// Calling the CLI passing the instance of this Helper class
		new CLI(this);
	}

	// Function to Generate Animals Names
	public static String petNameGenerator() {

		// Array of Names (1000 names)
		// Names got from :
		// https://www.petplace.com/article/dogs/pet-care/top-1200-pet-names/
		String[] petName = { "ABBEY", "ABBIE", "ABBY", "ABEL", "ABIGAIL", "ACE", "ADAM", "ADDIE", "ADMIRAL", "AGGIE",
				"AIRES", "AJ", "AJAX", "ALDO", "ALEX", "ALEXUS", "ALF", "ALFIE", "ALLIE", "ALLY", "AMBER", "AMIE",
				"AMIGO", "AMOS", "AMY", "ANDY", "ANGEL", "ANGUS", "ANNIE", "APOLLO", "APRIL", "ARCHIE", "ARGUS",
				"ARIES", "ARMANTI", "ARNIE", "ARROW", "ASHES", "ASHLEY", "ASTRO", "ATHENA", "ATLAS", "AUDI", "AUGIE",
				"AUSSIE", "AUSTIN", "AUTUMN", "AXEL", "AXLE", "BABBLES", "BABE", "BABY", "BABY-DOLL", "BABYKINS",
				"BACCHUS", "BAILEY", "BAM-BAM", "BAMBI", "BANDIT", "BANJO", "BARBIE", "BARCLAY", "BARKER", "BARKLEY",
				"BARLEY", "BARNABY", "BARNEY", "BARON", "BART", "BASIL", "BAXTER", "BB", "BEAMER", "BEANIE", "BEANS",
				"BEAR", "BEAU", "BEAUTY", "BEAUX", "BEBE", "BEETLE", "BELLA", "BELLE", "BEN", "BENJI", "BENNY",
				"BENSON", "BENTLEY", "BERNIE", "BESSIE", "BIABLO", "BIBBLES", "BIG BOY", "BIG FOOT", "BIGGIE", "BILLIE",
				"BILLY", "BINGO", "BINKY", "BIRDIE", "BIRDY", "BISCUIT", "BISHOP", "BITS", "BITSY", "BIZZY", "BJ",
				"BLACKIE", "BLACK-JACK", "BLANCHE", "BLAST", "BLAZE", "BLONDIE", "BLOSSOM", "BLUE", "BO", "BO", "BOB",
				"BOBBIE", "BOBBY", "BOBO", "BODIE", "BOGEY", "BONES", "BONGO", "BONNIE", "BOO", "BOO-BOO", "BOOKER",
				"BOOMER", "BOONE", "BOOSTER", "BOOTIE", "BOOTS", "BOOZER", "BORIS", "BOSCO", "BOSLEY", "BOSS", "BOY",
				"BOZLEY", "BRADLEY", "BRADY", "BRAGGS", "BRANDI", "BRANDO", "BRANDY", "BRIDGETT", "BRIDGETTE", "BRIE",
				"BRINDLE", "BRIT", "BRITTANY", "BRODIE", "BROOK", "BROOKE", "BROWNIE", "BRUISER", "BRUNO", "BRUTUS",
				"BUBBA", "BUBBLES", "BUCK", "BUCKEYE", "BUCKO", "BUCKY", "BUD", "BUDDA", "BUDDIE", "BUDDY", "BUDDY BOY",
				"BUFFIE", "BUFFY", "BUG", "BUGSEY", "BUGSY", "BULLET", "BULLWINKLE", "BULLY", "BUMPER", "BUNKY",
				"BUSTER", "BUSTER-BROWN", "BUTCH", "BUTCHY", "BUTTER", "BUTTERBALL", "BUTTERCUP", "BUTTERSCOTCH",
				"BUTTONS", "BUZZY", "CAESAR", "CALI", "CALLIE", "CALVIN", "CAMEO", "CAMILLE", "CANDY", "CAPONE",
				"CAPTAIN", "CARLEY", "CASEY", "CASPER", "CASSIE", "CASSIS", "CHA CHA", "CHAD", "CHAMBERLAIN", "CHAMP",
				"CHANCE", "CHANEL", "CHAOS", "CHARISMA", "CHARLES", "CHARLIE", "CHARLIE BROWN", "CHARMER", "CHASE",
				"CHAUNCEY", "CHAZ", "CHECKERS", "CHELSEA", "CHEROKEE", "CHESSIE", "CHESTER", "CHEVY", "CHEWIE", "CHEWY",
				"CHEYENNE", "CHI CHI", "CHIC", "CHICO", "CHIEF", "CHILI", "CHINA", "CHIP", "CHIPPER", "CHIPPY", "CHIPS",
				"CHIQUITA", "CHIVAS", "CHLOE", "CHOCOLATE", "CHRISSY", "CHUBBS", "CHUCKY", "CHYNA", "CINDER", "CINDY",
				"CINNAMON", "CISCO", "CLAIRE", "CLANCY", "CLEO", "CLEOPATRA", "CLICKER", "CLIFFORD", "CLOVER", "CLYDE",
				"COAL", "COBWEB", "COCO", "COCOA", "COCONUT", "CODI", "CODY", "COLE", "COMET", "COMMANDO", "CONAN",
				"CONNOR", "COOKIE", "COOPER", "COPPER", "CORKY", "COSMO", "COTTON", "COZMO", "CRACKERS", "CRICKET",
				"CRYSTAL", "CUBBY", "CUBS", "CUJO", "CUPCAKE", "CURLY", "CURRY", "CUTIE", "CUTIE-PIE", "CYRUS", "DAFFY",
				"DAISEY-MAE", "DAISY", "DAKOTA", "DALLAS", "DANDY", "DANTE", "DAPHNE", "DARBY", "DARCY", "DARWIN",
				"DASH", "DAVE", "DEACON", "DEE", "DEE DEE", "DEMPSEY", "DESTINI", "DEWEY", "DEXTER", "DHARMA",
				"DIAMOND", "DICKENS", "DIEGO", "DIESEL", "DIGGER", "DILLON", "DINKY", "DINO", "DIVA", "DIXIE", "DOBIE",
				"DOC", "DODGER", "DOGGON’", "DOLLY", "DOMINO", "DOODLES", "DOOGIE", "DOTS", "DOTTIE", "DOZER",
				"DRAGSTER", "DREAMER", "DUCHESS", "DUDE", "DUDLEY", "DUFFY", "DUKE", "DUNCAN", "DUNN", "DUSTY",
				"DUTCHES", "DUTCHESS", "DYLAN", "EARL", "EBONY", "ECHO", "EDDIE", "EDDY", "EDGAR", "EDSEL", "EIFEL",
				"EINSTEIN", "ELLIE", "ELLIOT", "ELMO", "ELVIS", "ELWOOD", "EMBER", "EMILY", "EMMA", "EMMY", "ERIN",
				"ERNIE", "EVA", "FAITH", "FANCY", "FELIX", "FERGIE", "FERRIS", "FIDO", "FIFI", "FIGARO", "FINNEGAN",
				"FIONA", "FLAKE", "FLAKEY", "FLASH", "FLINT", "FLOPSY", "FLOWER", "FLOYD", "FLUFFY", "FONZIE", "FOXY",
				"FRANCAIS", "FRANKIE", "FRANKY", "FRECKLES", "FRED", "FREDDIE", "FREDDY", "FREEDOM", "FREEWAY",
				"FRESIER", "FRIDAY", "FRISCO", "FRISKY", "FRITZ", "FRODO", "FROSTY", "FURBALL", "FUZZY", "GABBY",
				"GABRIELLA", "GARFIELD", "GASBY", "GATOR", "GAVIN", "GENIE", "GEORGE", "GEORGIA", "GEORGIE", "GIANT",
				"GIBSON", "GIDGET", "GIGI", "GILBERT", "GILDA", "GINGER", "GINNY", "GIRL", "GIZMO", "GODIVA", "GOLDIE",
				"GOOBER", "GOOSE", "GORDON", "GRACE", "GRACE", "GRACIE", "GRACIE", "GRADY", "GREENIE", "GRETA",
				"GRETCHEN", "GRETEL", "GRETTA", "GRIFFEN", "GRINGO", "GRIZZLY", "GROMIT", "GROVER", "GUCCI", "GUIDO",
				"GUINNESS", "GUNNER", "GUNTHER", "GUS", "GUY", "GYPSY", "HAILEY", "HALEY", "HALLIE", "HAMLET", "HAMMER",
				"HANK", "HANNA", "HANNAH", "HANS", "HAPPYT", "HARDY", "HARLEY", "HARPO", "HARRISON", "HARRY", "HARVEY",
				"HEATHER", "HEIDI", "HENRY", "HERCULES", "HERSHEY", "HIGGINS", "HOBBES", "HOLLY", "HOMER", "HONEY",
				"HONEY-BEAR", "HOOCH", "HOOVER", "HOPE", "HOUDINI", "HOWIE", "HUDSON", "HUEY", "HUGH", "HUGO",
				"HUMPHREY", "HUNTER", "INDIA", "INDY", "IRIS", "ISABELLA", "ISABELLE", "ITSY", "ITSY-BITSY", "IVORY",
				"IVY", "IZZY", "JACK", "JACKIE", "JACKPOT", "JACKSON", "JADE", "JAGGER", "JAGS", "JAGUAR", "JAKE",
				"JAMIE", "JASMINE", "JASPER", "JAXSON", "JAZMIE", "JAZZ", "JELLY", "JELLY-BEAN", "JENNA", "JENNY",
				"JERRY", "JERSEY", "JESS", "JESSE", "JESSE JAMES", "JESSIE", "JESTER", "JET", "JETHRO", "JETT", "JETTA",
				"JEWEL", "JEWELS", "JIMMUY", "JINGLES", "JJ", "JOE", "JOEY", "JOHNNY", "JOJO", "JOKER", "JOLIE",
				"JOLLY", "JORDAN", "JOSIE", "JOY", "JR", "JUDY", "JULIUS", "JUNE", "JUNIOR", "JUSTICE", "KALI",
				"KALLIE", "KANE", "KARMA", "KASEY", "KATIE", "KATO", "KATZ", "KAYLA", "KC", "KEESHA", "KELLIE", "KELLY",
				"KELSEY", "KENYA", "KERRY", "KIBBLES", "KID", "KIKI", "KILLIAN", "KING", "KIPPER", "KIRA", "KIRBY",
				"KISMET", "KISSY", "KITTY", "KIWI", "KLAUS", "KOBA", "KOBE", "KODA", "KOKO", "KONA", "KOSMO", "KOTY",
				"KRAMER", "KUJO", "KURLY", "KYRA", "LACEY", "LADDIE", "LADY", "LADYBUG", "LANEY", "LASSIE", "LATTE",
				"LAYLA", "LAZARUS", "LEFTY", "LEO", "LEVI", "LEXI", "LEXIE", "LEXUS", "LIBBY", "LIGHTNING", "LILI",
				"LILLY", "LILY", "LINCOLN", "LINUS", "LITTLE BIT", "LITTLE-GUY", "LITTLE-ONE", "LITTLE-RASCAL", "LIZZY",
				"LOGAN", "LOKI", "LOLA", "LOU", "LOUIE", "LOUIS", "LOVEY", "LUCAS", "LUCI", "LUCIFER", "LUCKY", "LUCY",
				"LUKE", "LULU", "LUNA", "LYNX", "MAC", "MACHO", "MACINTOSH", "MACK", "MACKENZIE", "MACY", "MADDIE",
				"MADDY", "MADISON", "MAGGIE", "MAGGIE-MAE", "MAGGIE-MOO", "MAGGY", "MAGIC", "MAGNOLIA", "MAJOR",
				"MANDI", "MANDY", "MANGO", "MARBLE", "MARIAH", "MARLEY", "MARY", "MARY JANE", "MASON", "MATTIE",
				"MAVERICK", "MAX", "MAXIMUS", "MAXINE", "MAXWELL", "MAY", "MAYA", "MCDUFF", "MCKENZIE", "MEADOW",
				"MEGAN", "MEGGIE", "MERCEDES", "MERCLE", "MERLIN", "MIA", "MIASY", "MICHAEL", "MICKEY", "MIDNIGHT",
				"MIKEY", "MIKO", "MILES", "MILLER", "MILLIE", "MILO", "MIMI", "MINDY", "MING", "MINI", "MINNIE",
				"MISCHIEF", "MISHA", "MISS KITTY", "MISS PRISS", "MISSIE", "MISSY", "MISTER", "MISTY", "MITCH",
				"MITTENS", "MITZI", "MITZY", "MO", "MOCHA", "MOJO", "MOLLIE", "MOLLY", "MONA", "MONKEY", "MONSTER",
				"MONTANA", "MONTGOMERY", "MONTY", "MOOCHER", "MOOCHIE", "MOOKIE", "MOONSHINE", "MOOSE", "MORGAN",
				"MOSES", "MOUSE", "MR KITTY", "MUFFIN", "MUFFY", "MUGSY", "MULLIGAN", "MUNCHKIN", "MURPHY", "NAKITA",
				"NALA", "NANA", "NAPOLEON", "NATASHA", "NATHAN", "NELLIE", "NEMO", "NENA", "NERO", "NESTLE", "NEWT",
				"NEWTON", "NIBBLES", "NIBBY", "NIBBY-NOSE", "NICK", "NICKERS", "NICKIE", "NICKY", "NICO", "NIKE",
				"NIKI", "NIKITA", "NIKKI", "NIKO", "NINA", "NITRO", "NOBEL", "NOEL", "NONA", "NOODLES", "NORTON",
				"NOSEY", "NUGGET", "NUTMEG", "OAKLEY", "OBIE", "ODIE", "OLD GLORY", "OLIVE", "OLIVER", "OLIVIA",
				"OLLIE", "ONIE", "ONYX", "OPIE", "OREO", "OSCAR", "OTIS", "OTTO", "OZ", "OZZIE", "OZZY", "PABLO",
				"PACO", "PADDINGTON", "PADDY", "PANDA", "PANDORA", "PANTHER", "PAPA", "PARIS", "PARKER", "PASHA",
				"PATCH", "PATCHES", "PATRICKY", "PATSY", "PATTY", "PEACHES", "PEANUT", "PEANUTS", "PEARL", "PEBBLES",
				"PEDRO", "PENNY", "PEPE", "PEPPER", "PEPPY", "PEPSI", "PERSY", "PETE", "PETER", "PETEY", "PETIE",
				"PHANTOM", "PHOEBE", "PHOENIX", "PICASSO", "PICKLES", "PIERRE", "PIGGY", "PIGLET", "PINK PANTHER",
				"PINKY", "PINTO", "PIPER", "PIPPIN", "PIPPY", "PIP-SQUEEK", "PIRATE", "PIXIE", "PLATO", "PLUTO",
				"POCKETS", "POGO", "POKEY", "POLLY", "PONCHO", "PONGO", "POOCH", "POOCHIE", "POOH", "POOH-BEAR",
				"POOKIE", "POOKY", "POPCORN", "POPPY", "PORCHE", "PORKCHOP", "PORKY", "PORTER", "POWDER", "PRANCER",
				"PRECIOUS", "PRESLEY", "PRETTY", "PRETTY-GIRL", "PRINCE", "PRINCESS", "PRISSY", "PUCK", "PUDDLES",
				"PUDGE", "PUFFY", "PUGSLEY", "PUMPKIN", "PUNKIN", "PUPPY", "PURDY", "QUEEN", "QUEENIE", "QUINCY",
				"QUINN", "RAGS", "RAISON", "RALPH", "RALPHIE", "RAMBLER", "RAMBO", "RANGER", "RASCAL", "RAVEN", "REBEL",
				"RED", "REGGIE", "REILLY", "REMY", "REX", "REXY", "RHETT", "RICKY", "RICO", "RIGGS", "RILEY",
				"RIN TIN TIN", "RINGO", "RIPLEY", "ROCCO", "ROCK", "ROCKET", "ROCKO", "ROCKY", "ROLAND", "ROLEX",
				"ROLLIE", "ROMAN", "ROMEO", "ROSA", "ROSCOE", "ROSEBUD", "ROSIE", "ROSY", "ROVER", "ROWDY", "ROXANNE",
				"ROXIE", "ROXY", "RUBY", "RUCHUS", "RUDY", "RUFFE", "RUFFER", "RUFFLES", "RUFUS", "RUGER", "RUSTY",
				"RUTHIE", "RYDER", "SABINE", "SABLE", "SABRINA", "SADIE", "SAGE", "SAILOR", "SALEM", "SALLY", "SALTY",
				"SAM", "SAMANTHA", "SAMMY", "SAMPSON", "SAMSON", "SANDY", "SARA", "SARAH", "SARGE", "SASHA", "SASSIE",
				"SASSY", "SAVANNAH", "SAWYER", "SCARLETT", "SCHOTZIE", "SCHULTZ", "SCOOBIE", "SCOOBY", "SCOOBY-DOO",
				"SCOOTER", "SCOTTIE", "SCOUT", "SCRAPPY", "SCRUFFY", "SEBASTIAN", "SHADOW", "SHADY", "SHAGGY", "SHASTA",
				"SHEBA", "SHEENA", "SHELBY", "SHELLY", "SHERMAN", "SHILOH", "SHINER", "SHORTY", "SIENNA", "SIERRA",
				"SILKY", "SILVER", "SILVESTER", "SIMBA", "SIMON", "SIMONE", "SISSY", "SKEETER", "SKINNY", "SKIP",
				"SKIPPER", "SKIPPY", "SKITTLES", "SKY", "SKYE", "SKYLER", "SLICK", "SLINKY", "SLY", "SMARTY", "SMOKE",
				"SMOKEY", };

		Random ran = new Random();

		// pick a Pet Name based on length of array
		String name = petName[ran.nextInt(petName.length)];

		// Return the Name, and Fix the name to left just the First Letter in Capital
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

	}

	// Function to Generate Medical Condition Names
	public static String medicalCondition() {

		// Array of Medical Condition
		// Names got from :
		// https://www.petmd.com/dog/conditions
		String[] illness = { "Abnormal Development of the Elbow", "Abnormal Eyelid",
				"Abnormal Growths in the Lower Intestines of ", "Abnormal Heart Rhythm", "Abnormal Molar Development",
				"Abnormal Passage Between Artery and Vein", "Abnormal Passageway Between the Mouth and Nasal Cavity",
				"Abnormal Protein Production", "Abnormal Urine Outflow Due to Urinary Bladder Dysfunction", "Abortion",
				"Abscesses", "Accumulation of Air Between Chest and Lungs", "Acid Reflux", "Acne",
				"Acute (Sudden) Dog Diarrhea", "Acute Respiratory Distress Syndrome (ARDS)", "Acute Vomiting",
				"Addison’s Disease", "Adenovirus 1", "Adrenal Gland Cancer (Pheochromocytoma)",
				"Adverse Reaction to Glow Stick Jewelry", "Aggression (Overview)", "Aggression Toward Familiar People",
				"Allergic Shock", "Ameba Infection", "Amphetamine Poisoning", "Anaerobic Bacterial Infections",
				"Anal Gland Cancer", "Anal Sac Disorders", "Anemia (Methemoglobinemia)",
				"Anemia Due to Bone Marrow Failure (or Toxicity)", "Anemia Due to Chronic Kidney Disease",
				"Anemia Due to Deformed Red Blood Cells", "Anemia Due to Enlarged Blood Cells",
				"Anemia Due to Iron Deficiency", "Anemia Related to the Immune System", "Anemia", "Anemia",
				"Antibiotic-resistant Bacterial Infections", "Antibiotic-Resistant Infections",
				"Antibodies that Attack Blood Cells at Lower Temperatures", "Anticoagulant Poisoning",
				"Antifreeze Poisoning", "Antifreeze Poisoning", "Anxiety and Compulsive Disorders",
				"Are Lilies Poisonous to ?", "Are Onions and Garlic Bad For Your Dog?",
				"Arrhythmias after Blunt Heart Trauma", "Arsenic Poisoning", "Artery Inflammation",
				"Arthritis (Septic)", "Arthritis of Multiple Joints", "Aspirin Poisoning",
				"Bacterial Infection (Actinomycosis)", "Bacterial Infection (Campylobacteriosis)",
				"Bacterial Infection (Leptospirosis)", "Bacterial Infection (Metritis) of the Uterus",
				"Bacterial Infection (Mycoplasma", "Bacterial Infection (Nocardiosis)",
				"Bacterial Infection (Pyelonephritis) of the Kidneys", "Bacterial Infection (Streptococcus)",
				"Bacterial Infection (Tularemia)", "Bacterial Infection (Tyzzer Disease)",
				"Bacterial Infection of the Breast", "Bad Breath (Chronic)",
				"Baldness and Hormone-Related Skin Disorders", "Bartonella Infection", "Bile Duct Cancer",
				"Bile Duct Obstruction", "Birth Difficulties", "Black Widow Spider Bite Poisoning", "Black",
				"Bladder Inflammation with Polyps", "Bleeding Disorder", "Bleeding of the Retina in the Eye",
				"Bleeding Under the Skin of ", "Blind Quiet Eye", "Bloat or Stomach Dilatation",
				"Blood Clot in the Lungs", "Blood in the Chest", "Blood in the Front of the Eye", "Blood in the Urine",
				"Blood Related Deficiencies", "Blood Thickening", "Blood Transfusion Reactions",
				"Blue Skin and Mucus Membranes", "Bone Cancer (Chondrosarcoma)", "Bone Cancer (Fibrosarcoma)",
				"Bone Cancer (Hemangiosarcoma)", "Bone Cancer (Osteosarcoma)", "Bone Deformity and Dwarfism",
				"Bone Infection", "Bone Inflammation (Hypertrophic Osteodystrophy) in Puppies",
				"Bone Inflammation (Panosteitis)", "Bone Marrow Cancer (Myeloma)", "Bone Overgrowth",
				"Botflies (Maggots)", "Botulism", "Brain and Spinal Cord Inflammation (Meningoencephalomyelitis",
				"Brain and Spinal Cord Inflammation", "Brain Cell Degeneration", "Brain Disorder Due to Liver Disease",
				"Brain Inflammation Due to Parasitic Infection", "Brain Inflammation", "Brain Injury",
				"Brain Tissue Inflammation and Death (Breed Specific)", "Brain Tissue Undervelopment",
				"Brain Tumor (Astrocytoma)", "Brain Tumors", "Breast Cancer (Mammary Gland Tumors)",
				"Breathing Difficulties", "Breathing Problem in Short-Nose Breed ", "Breeding Timing",
				"Brown Recluse Spider Bite Poisoning", "Calcium Buildup in Lungs of ",
				"Calcium Deposits in the Urinary Tract", "Can  Be Allergic to Grass?", "Can  Eat Cinnamon?",
				"Can  Get High? The Dangerous Effects of Marijuana on ", "Can  Have Panic Attacks?",
				"Can Grass Kill Your Dog?", "Cancer of the Blood Vessel Cells",
				"Cancerous and Non-Cancerous Growths in a  Mouth", "Cancerous Lymphoid Cells in the Lungs of ",
				"Canine Coronavirus Infection", "Capillariasis", "Carbon Monoxide Poisoning", "Carcinoid Cancer",
				"Cardiac Arrest", "Cardiac Electrical Failure", "Cardiomyopathy in Boxer ", "Carnitine Deficiency",
				"Cataracts", "Cavities", "Chagas Disease", "Chemical Imbalance of Urine", "Chest Bone Deformity",
				"Chocolate Poisoning", "Chronic Inflammation of the Anus", "Chronic Inflammation of the Bronchi",
				"Chronic Vomiting", "Cirrhosis and Fibrosis of the Liver", "Claw and Nail Disorders", "Cleft Palate",
				"Clotting Deficiency (Inherited)", "Clotting Deficiency (Liver Related)",
				"Clotting Disorders of the Platelets", "Collapse During Exercise in Labrador Retrievers",
				"Collapse of the Wind Pipe", "Collection of Fluid in the Lungs (Not Due to Heart Disease)",
				"Collie Eye Defect", "Colonic or Rectal Inflammation", "Colonic Ulcer",
				"Conditions Due to Abnormal Secretions from a Tumor", "Congenital Heart Defect (Atrial Septal Defect)",
				"Congenital Heart Defect (Ebstein’s Anomaly)", "Congenital Heart Defect (Pulmonic Stenosis)",
				"Conjunctivitis (Pink Eye)", "Constipation (Severe)", "Constipation", "Coonhound Paralysis",
				"Coral Snake Bite Poisoning", "Corneal Disease (Inherited)",
				"Corneal Inflammation (Nonulcerative Keratitis)", "Coughing", "Cushings Disease", "Cyst on the Gums",
				"Defect of the Ventricular Septum", "Degeneration of the Cerebellum of the Brain",
				"Degeneration of the Cornea", "Degeneration of the Image Forming Part of the Eye",
				"Degeneration of the Iris in the Eye", "Degenerative Joint Disease",
				"Degenerative Skin Disorder (Necrolytic Dermatitis)", "Demodectic Mange",
				"Destruction of the Pituitary Gland", "Destructive Behavior", "Diabetes (Hepatopathy)", "Diabetes",
				"Diabetes with Coma", "Diabetes with Ketone Bodies", "Diarrhea (Long-term)",
				"Diarrhea Due to Clostridium perfringens", "Dietary Reactions",
				"Difficult Defecation and Blood in Stool", "Diseases of the Orbit of the Eye",
				"Diseases of the Skin on the Nose", "Dislocated Eye Lens", "Distemper",
				"Do Carrots Naturally Improve Your  Vision?", "Does Your Dog Have a Snoring Problem?",
				"Does Your Dog Have Asthma?", "Dog Ear Infection - Symptoms and Treatments",
				"Dog Abdominal Cavity Inflammation - Dog Peritoneal Cavity", "Dog Dementia: Symptoms",
				"Dog Diarrhea Treatment And Cures - Diarrhea (Antibiotic-Responsive)", "Dog Flu",
				"Dog Mouth Cancer: Symptoms", "Dog Vomit: Types", " and Motion Sickness", "Droopy Eye",
				"Drowning (Near Drowning)", "Drug Poisoning", "Dry Eye Syndrome", "E", "Ear Cancer (Adenocarcinoma)",
				"Ear Cancer", "Ear Cysts (Cholesteatoma)", "Ear Hematoma", "Early Contractions and Labor",
				"Early Death in Puppies", "Electric Cord Bite Injury", "Electrolyte Disturbance",
				"Elevated Sex Hormones", "Enlarged Gums", "Enlarged Heart (Dilated Cardiomyopathy)", "Enlarged Liver",
				"Enlarged Spleen", "Enlargement of Esophagus", "Estrus Symptoms after Spaying", "Ethanol Poisoning",
				"Excess Acidity in the Blood", "Excess Alkali in the Blood", "Excess Blood Cells in the Eye",
				"Excess Calcium in the Blood", "Excess Carbon Dioxide in the Blood", "Excess Chloride in the Blood",
				"Excess Iron in the Blood", "Excess Magnesium in the Blood", "Excess Phosphorous in the Blood",
				"Excess Protein in the Urine of ", "Excess Sodium in the Blood",
				"Excessive Bacteria in the Small Intestine", "Excessive Blood Clotting", "Excessive Blood Clotting",
				"Excessive Dog Barking and Vocalization", "Excessive Potassium in the Blood",
				"Excessive Production of Saliva", "Extreme Fear and Anxiety", "Eye Defects (Congenital)",
				"Eye Displacement", "Eye Infection in Newborn ", "Eye Inflammation (Anterior Uveitis)",
				"Eye Inflammation (Blepharitis)", "Eye Inflammation (Choroid and Retina)", "Eye Injuries", "Eye Ulcer",
				"Eyelash Disorders", "Eyelid Protrusion (Cherry Eye)", "Eyeworm Infection",
				"Failure to Absorb Vitamin B12", "Failure to Thrive in Collie ", "Fainting",
				"False Pregnancy in Female ", "Familial Shar-Pei Fever", "Fatty Layer or Nodule Under the Skin",
				"Fatty Skin Tumors", "Fatty Tissue Inflammation", "Fatty Tissue Tumor (Benign)", "Fever",
				"Fibrotic Hardening of the Lungs (Pneumonia)", "Flatworm Parasite (Heterobilharzia)",
				"Flea Allergies (Flea Allergy Dermatitis)", "Flea and Tick Medicine Poisoning",
				"Fluid Buildup in the Kidney Due to Kidney or Ureter Obstruction",
				"Fluid Buildup in the Sac Surrounding the Heart", "Fluid in Abdomen",
				"Fluid in Chest (Pleural Effusion)", "Fluid in the Chest", "Fluid in the Lungs",
				"Fluid Retention and Tissue Swelling Due to Collection of Lymph", "Folding of the Intestines",
				"Foot/Toe Cancer", "Foreign Objects Stuck in the Throat", "Fox Tapeworm Infection (Cysticercosis)",
				"Fractures of Upper Jaw and Lower Jaw", "Front Leg Deformity", "Front Leg Injury",
				"Fungal Disease (Sporotrichosis) of the Skin", "Fungal Infection (Aspergillosis)",
				"Fungal Infection (Blastomycosis)", "Fungal Infection (Coccidioidomycosis)",
				"Fungal Infection (Histoplasmosis)", "Fungal Infection (Malassezia pachydermatis) of the Skin",
				"Fungal Infection (Pneumocystosis) of the Lung", "Fungal Infection (Rhinosporidiosis)",
				"Fungal Infection (Yeast)", "Fungal Infection of the Lower Urinary Tract",
				"Fungal Toxicosis Related To Aspergillus flavus", "Fungal Toxicosis Related to Fusarium Fungus",
				"Gallbladder and Bile Duct Inflammation", "Gallbladder Obstruction", "Gallstones",
				"Generalized Inflammatory Muscle Diseases", "Genetic Liver Abnormality", "Giant Cell Tumors",
				"Glaucoma", "Glomerulonephritis", "Glucose in the Urine",
				"Gluten-Sensitive Enteropathy in Irish Setters", "Glycogen Storage Disease", "Gum Disease",
				"Hair Follicle Tumors", "Hair Loss Due to Lack of Growth Hormone", "Hair Loss",
				"Hardening and Blockage of the Arteries", "Head Pressing", "Head Shaking: When to Worry", "Head Tilt",
				"Hearing Loss", "Heart (Aortic) Blood Clot", "Heart (Aortic) Valve Narrowing",
				"Heart and Carotid Artery Tumors", "Heart Attack", "Heart Beat Problems (Fibrillation and Flutter)",
				"Heart Beat Problems (Premature Complexes)", "Heart Beat Problems (Standstill)",
				"Heart Block (Complete)", "Heart Block (First-Degree)", "Heart Block (Mobitz Type I)",
				"Heart Block (Mobitz Type II)", "Heart Block or Conduction Delay (Left Anterior)",
				"Heart Block or Conduction Delay (Left Bundle)", "Heart Block or Conduction Delay (Right Bundle)",
				"Heart Cancer (Hemagiosarcoma)", "Heart Defect (Congenital)",
				"Heart Disease (Hypertrophic Cardiomyopathy)", "Heart Disease of the Sinus Node",
				"Heart Failure Due to Valve Defect", "Heart Failure", "Heart Failure", "Heart Impulse Block",
				"Heart Inflammation (Myocarditis)", "Heart Medicine Poisoning", "Heart Murmurs",
				"Heart Sac Inflammation (Pericarditis)", "Heart Tumor (Rhabdomyoma)", "Heart Tumors (Myocardial)",
				"Heart Valve Infection (Infective Endocarditis)", "Heart Valve Malformation",
				"Heart Valve Narrowing (Mitral and Tricuspid)", "Heartworm Disease: Symptoms",
				"Heat Stroke and Hyperthermia", "Hematoma on ", "Hemoglobin and Myoglobin in Urine",
				"Hemorrhage of the Lung", "Hepatozoonosis (Tick-Borne Disease)",
				"Hereditary Muscle Disease (Non-inflammatory Myopathy) in Labrador Retrievers", "Hereditary",
				"Hernia (Diaphragmatic)", "Hernia (Hiatal)", "Hernia (Inguinal)",
				"Hernia Between the Pericardium and Peritoneum", "High Blood Pressure",
				"High Blood Pressure in the Lungs", "High Blood Pressure in the Portal Vein to the Liver",
				"High Blood Sugar", "High Cholesterol", "High Level of Plasma Proteins in the Blood of ",
				"High Levels of Blood Nitrogen", "Hip Dysplasia", "Hives", "Hole in the Trachea", "Hookworms",
				"Hormone Replacement Poisoning", "House Soiling (Marking) by ", "Hypercalcemic Agent Poisoning",
				"Hyperparathyroidism Due to Kidney Failure", "Hyperparathyroidism", "Hyperthyroidism", "Hypothyroidism",
				"Ibuprofen Toxicity", "Identifying and Treating Tapeworms", "Inability to Protrude or Retract Penis",
				"Inability to Urinate", "Incoordination of the Legs", "Increased Appetite",
				"Increased Heart Rate Due to Premature Contractions", "Increased Urination and Thirst",
				"Infertility in Female ", "Infertility in Male ", "Inflamed Chewing Muscles and Eye Muscles",
				"Inflammation of Body Blood Vessels", "Inflammation of the Abdomen Due to Bile Leakage",
				"Inflammation of the Esophagus", "Inflammation of the Middle Ear and External Ear Canal",
				"Inflammation of the Pancreas", "Inflammation of the Skin Blood Vessels", "Inflammation of the Skin",
				"Inflammation of the Soft Tissues in the Mouth", "Inflammation of the Superficial Veins",
				"Inflammatory Bowel Disease (IBD)", "Inflammatory Bowel Disease Due to Lymphocytes and Plasma",
				"Inflammatory Bowel Disease", "Inflammatory Skin Disease", "Ingestion of Feces and Foreign Objects",
				"Insecticide Poisoning", "Insufficient Urine Production",
				"Intervertebral Disc Disease (IVDD) – Slipped Disc", "Intestinal Cancer (Adenocarcinoma)",
				"Intestinal Disorder (Loss of Motility)", "Intestinal Obstruction", "Intestinal Parasite (Coccidia)",
				"Intestinal Parasite (Cryptosporidium)", "Intestinal Parasitic Infection (Strongyloidiasis)",
				"Intestinal Protein Loss", "Intestinal Tumor (Leiomyoma)", "Intestinal Tumors (Apudomas)",
				"Intestinal Viral Infection (Rotavirus)", "Intestinal Virus (Reovirus) Infection",
				"Involuntary Muscle Trembling", "Iris Bombe", "Iris Cysts", "Irregular Heart Beat",
				"Irregular Heart Rhythms", "Irregular Heartbeat", "Irritable Bowel Syndrome",
				"Is Dry Nose a Sign of Illness?", "Is Your Pet’s Excessive Shedding a Sign of Illness?", "Itchiness",
				"Jumping", "Jawbone Enlargement", "Joint Cancer (Synovial Sarcoma)", "Joint Cartilage Erosion",
				"Joint Dislocation", "Kennel Cough", "Key-Gaskell Syndrome", "Kidney Cancer (Adenocarcinoma)",
				"Kidney Disease (Congenital)", "Kidney Disease Caused by Multiple Cysts", "Kidney Disease",
				"Kidney Enlargement", "Kidney Failure and Excess Urea in the Urine", "Kidney Failure (Long-Term)",
				"Kidney Filtration Problems", "Kidney Inflammation Due to Fluid Accumulation",
				"Kidney Stones (Struvite)", "Kidney Stones", "Kidney Toxicity (Drug-Induced)", "Kneecap Dislocation",
				"Lack of Bladder Control", "Lack of Bowel Control", "Lack Of Digestive Enzymes", "Lactic Acid Build-Up",
				"Lameness", "Laryngeal Disease", "Lead Poisoning", "Legg-Calvé-Perthes Disease", "Leukemia (Acute)",
				"Leukemia (Chronic)", "Lice", "Liver and Spleen Cancer (Hemangiosarcoma)", "Liver Cancer: Symptoms",
				"Liver Disease (Copper Storage)", "Liver Disease", "Liver Failure (Acute)", "Liver Fibrosis in Young ",
				"Liver Fistula", "Liver Inflammation (Chronic)", "Liver Inflammation (Granulomatous)",
				"Liver Inflammation (Suppurative)", "Liver Inflammation", "Liver Toxins",
				"Liver Tumor (Hepatocellular Adenoma)", "Liver Tumors in Older ", "Lizard Venom Poisoning", "Lockjaw",
				"Long-Term Stomach Inflammation", "Loss of Appetite", "Loss of Balance (Unbalanced Gait)",
				"Low Blood Albumin", "Low Blood Calcium", "Low Blood Oxygen", "Low Blood Potassium", "Low Blood Sugar",
				"Low Body Temperature", "Low Platelet Count", "Low Production of Parathyroid Hormone",
				"Low White Blood Cell Count", "Lower Eyelid Droop", "Lung Cancer (Adenocarcinoma)",
				"Lung Cancer (Squamous Cell Carcinoma)", "Lung Lobe Twisting", "Lungworms", "Lyme Disease",
				"Lymph Node Inflammation (Lymphadenitis)", "Lymph Node Inflammation (Lymphadenopathy)",
				"Lymph Node Inflammation", "Lymphoma", "Mad Itch Pseudorabies Virus Infection", "Magnesium Deficiency",
				"Masculinizing Sex Hormone Deficiency", "Mass Protrusion from the Vaginal Area",
				"Mast Cell Tumor (Mastocytoma)", "Maternal Behavior Problems in Female ", "Meningitis", "Mesothelioma",
				"Metabolic Enzyme Deficiency", "Metabolic Muscle Disease without Inflammation",
				"Miscarriage Due to Bacterial Infection (Brucellosis)", "Miscarriage", "Mosquitoes and Your  and Cats",
				"Mothball Toxicity in Pets: What You Need to Know", "Mouth Cancer (Adenocarcinoma)",
				"Mouth Cancer (Amelobastoma)", "Mouth Cancer (Chondrosarcoma)", "Mouth Cancer (Gingiva Fibrosarcoma)",
				"Mouth Cancer (Gingiva Squamous Cell Carcinoma)", "Mouth Cancer (Melanocytic)",
				"Mouth Inflammation and Ulcers (Chronic)", "Mucopolysaccharidoses", "Mucus in Dog Stool", "Mumps",
				"Muscle Contraction Disease (Myoclonus)", "Muscle Cramps in Scottish Terriers", "Muscle Tear",
				"Mushroom Poisoning", "Mushroom", "Myelin Deficiency", "Myeloproliferative Disorders",
				"Narcolepsy and Cataplexy", "Narrowed Bronchi", "Narrowing of Pyloric Canal",
				"Narrowing of the Anal or Rectal Opening", "Narrowing of the Esophagus", "Narrowing of Vertebral Canal",
				"Nasal Passage Narrowing", "Neck and Back Pain", "Nerve Disorder Affecting Multiple Nerves",
				"Nerve Sheath Tumor", "Nerve/Muscle Disorder", "Neuropathic Pain", "Noisy Breathing",
				"Non-Inflammatory Hereditary Muscle Disease", "Non-inflammatory Myopathy of Endocrine Origin",
				"Nonsteroidal Anti-Inflammatory Drug Toxicity", "Nose and Sinus cancer (Squamous Cell Carcinoma)",
				"Nose and Sinus Inflammation", "Nose Bleed", "Nose Cancer (Adenocarcinoma)",
				"Nose Cancer (Chondrosarcoma)", "Nose Cancer (Fibrosarcoma)",
				"Nose Pad Cancer (Squamous Cell Carcinoma)", "Obesity: Symptoms", "Optic Nerve Swelling",
				"Osteochondritis Dissecans (OCD)", "Out-of-place Urethral Lining", "Ovarian Tumors",
				"Overproduction of Estrogen", "Overproduction of Red Blood Cells",
				"Overproduction of White Blood Cells in the Bone Marrow", "Pain (Acute", "Painful Abdomen",
				"Painful and Frequent Urination", "Pancreatic Cancer (Adenocarcinoma)",
				"Pancreatic Cancer (Glucagonoma)", "Pancreatic Cancer (Insulinoma)",
				"Paralysis Due to Spinal Cord Injury", "Paralysis Due to Spinal Cord Lesion", "Paralysis",
				"Paralysis of the Jaw", "Parasite Drug (Ivermectin) Poisoning", "Parasite Infection (Babesiosis)",
				"Parasite Infection (Leishmaniasis)", "Parasitic Blood Infection (Haemobartonellosis)",
				"Parasitic Diarrhea (Giardiasis)", "Parasitic Infection (Microsporidiosis Encephalitozoonosis)",
				"Parasitic Infection (Neosporosis)", "Parasitic Infection of the Respiratory Tract",
				"Particles in the Urine", "Parvo", "Pelger-Huët Anomaly", "Pennyroyal Oil Poisoning", "Perineal Hernia",
				"Phosphofructokinase Deficiency", "Pink Growths in the Nose", "Pit Viper Bite Poisoning", "Plague",
				"Pneumonia (Aspiration)", "Pneumonia (Bacterial)", "Pneumonia (Fungal)", "Pneumonia (Interstitial)",
				"Pneumonia Due to Overactive Immune Response", "Poisoning by Petroleum Products",
				"Poisoning Due to Ingesting Rat Poison", "Poisoning", "Pork Roundworm Infection",
				"Possessive and Territorial Aggression", "Posterior Displacement of the Bladder",
				"Postpartum Low Blood Calcium", "Pouch-like Sacs on the Esophageal Wall",
				"Prostate Cancer (Adenocarcinoma)", "Prostate Disease in the Breeding Male Dog", "Prostate Enlargement",
				"Prostate Gland Enlargement", "Prostate Inflammation and Abscessation", "Prostatic Cysts",
				"Protein Deposits in Liver (Amyloidosis)", "Protein Deposits in the Body",
				"Protrusion of the Rectum and Anus", "Puppy Strangles", "Pus Cavity Forming Under Tooth",
				"Pus in the Chest Cavity of ", "Pus in the Urine", "Pyoderma (Bacterial Skin Infections)",
				"Pyruvate Kinase Deficiency", "Q Fever", "Rabies", "Racoon Disease", "Rapid Cellular Growth",
				"Rapid Heart Beat", "Rapid Heart Rate", "Rat Poison Toxicity", "Rat Poisoning",
				"Red Eye (Episcleritis)", "Red Eye", "Reduced Activity of the Stomach", "Regurgitation",
				"Retained Afterbirth", "Retained Baby Teeth", "Retained Testicles ", "Rickettsial Infection",
				"Ringworm", "Rocky Mountain Spotted Fever", "Roundworms",
				"Running Away from Home and Marking Territory", "Runny Nose",
				"Safety Tips for Using Heartworm Preventive Medications on ", "Sago Palm Poisoning",
				"Salmon Poisoning Disease", "Salmonella Infection", "Sarcocystis Infection", "Sarcoptic Mange",
				"Scaly Skin", "Seizures (Epileptic)", "Seizures and Convulsions", "Separation Anxiety",
				"Separation of the Inner Lining of the Eye", "Septicemia and Bacteremia",
				"Severely Abnormal Heart Rhythm", "Sexual Development Disorders", "Sexually Transmitted Tumors",
				"Shaker Syndrome", "Shock Due to Bacterial Infection", "Shock Due to Decrease in Circulation",
				"Shock Due to Heart Failure", "Shoulder Joint Ligament and Tendon Conditions",
				"Side Effects of Anxiety Medications", "Signs and Symptoms of Bloat", "Sjögren-like Syndrome",
				"Skin and Eye Inflammation Due to Autoimmune Disorder (Uveodermatologic Syndrome)",
				"Skin and Toe Cancer (Melanocytic)", "Skin Blisters (Vesiculopustular Dermatoses)",
				"Skin Blisters and Pustules", "Skin Bumps (Granulomatous Dermatoses)",
				"Skin Bumps (Papulonodular Dermatoses)", "Skin Cancer (Adenocarcinoma)",
				"Skin Cancer (Basal Cell Tumor)", "Skin Cancer (Epidermotropic Lymphoma)",
				"Skin Cancer (Hemangiosarcoma)", "Skin Cancer (Mucocutaneous Plasmacytoma)",
				"Skin Cancer (Squamous Cell Carcinoma)", "Skin Disease (Canine Seborrhea)",
				"Skin Disease (Dermatophilosis)", "Skin Disease Caused by Licking",
				"Skin Disease Due to Food Allergies", "Skin Disease", "Skin Diseases from Allergies",
				"Skin Infections and Loss of Skin Color Disorders", "Skin Inflammation on the Paws",
				"Skin Mite Dermatitis", "Skin Rash Due to Contact with Irritants", "Skin Reactions to Drugs",
				"Skin Tumor (Histiocytoma)", "Skin Ulcers and Depigmentation (Immune-Related)", "Skin Ulcers",
				"Skull and Spinal Cord Abnormalities", "Small Sized Testes", "Smoke Inhalation", "Snail",
				"Sodium Deficiency", "Soft Tissue Cancer (Rhabdomyosarcoma)", "Spasm of the Rear Legs",
				"Sperm Abnormalities", "Sperm Ducts Cysts", "Spinal and Vertebral Birth Defects",
				"Spinal Column Malformation", "Spinal Cord Degeneration in Rottweilers",
				"Spinal Cord Development Disorders", "Spinal Cord Disease",
				"Spinal Cord Disorder Caused by Blocked Blood Vessel", "Spine Degeneration", "Stained",
				"Stalled Labor and Delivery Problems", "Staph Infection",
				"Stem Cell Disorders Due to Abnormal Development and Maturation", "Steroid-Related Liver Disease",
				"Steroid-Responsive Meningitis-Arteritis", "Stomach and Intestinal Cancer (Leiomyosarcoma)",
				"Stomach and Intestinal Inflammation", "Stomach and Intestinal Ulcers",
				"Stomach Disorder (Loss of Motility)", "Stomach Flu with Bloody Diarrhea",
				"Stomach Infection with Helicobacter", "Stomach Inflammation (Atrophic)",
				"Stomach Worm Infection (Physalopterosis)", "Stretchy", "Stroke", "Stupor and Coma",
				"Swallowing Difficulties", "Swelling", "Swelling of the Optic Disk in the Retina of ",
				"Swelling of the Salivary Gland", "Swollen Gums", "Symptoms of Lead Poisoning in Pets", "Synechiae",
				"Systemic Autoimmune Disease", "Taurine Deficiency", "Tear in the Heart", "Teeth Misalignment",
				"Temporomandibular Joint Disorders", "Testicular Swelling", "Testicular Tumor (Leydig Cell)",
				"Testicular Tumor (Seminoma)", "Testicular Tumor (Sertoli Cell)", "Tetralogy of Fallot",
				"Thickening of the Uterus Lining and Fluid-filled Sac", "Throat Cancer (Chondrosarcoma)",
				"Thunderstorm Phobias", "Thyroid Cancer (Adenocarcinoma)", "Thyroid Gland Disorder",
				"Tick Medicine Poisoning", "Tick Paralysis", "Ticks and Tick Control", "Toad Venom Toxicosis",
				"Tongue Cancer (Squamous Cell Carcinoma)", "Tonsil Cancer (Squamous Cell Carcinoma)",
				"Too much Acid in the Body", "Tooth Dislocation or Sudden Loss", "Tooth Enamel Malformation",
				"Tooth Fracture", "Torn Knee Ligament", "Toxicity from Gum", "Toxoplasmosis",
				"Transitional Cell Carcinoma of the Urinary Tract", "Tremors and Seizures", "Tumor of the Eye",
				"Tumor of the Meninges", "Tumor of the Nerves", "Tumor of the Thymus", "Tumor of the Uterus",
				"Tumor Related to Vaccinations", "Tumors of the Endocrine Glands", "Tumors of the Gums (Epulis)",
				"Tumors of the Vagina", "Twisted Spleen", "Tylenol (Acetaminophen) Poisoning", "Umbilical Hernia",
				"Uncoordinated Cilia Function", "Unequal Pupil Size", "Unintentional Eye Movement", "Unruly Behaviors",
				"Ureter Stones", "Urethral Shaft Abnormality", "Urinary Bladder Cancer (Rhabdomyosarcoma)",
				"Urinary Tract / Kidney Stones (Cystine)", "Urinary Tract / Kidney Stones (Calcium Phosphate)",
				"Urinary Tract Infection", "Urinary Tract Obstruction",
				"Urinary Tract Stones/Crystals Made Up of Uric Acid", "Urine Crystals", "Uterine Abnormalities",
				"Vaginal Abnormalities", "Vaginal Discharge", "Vaginal Inflammation", "Vascular Ring Anomalies",
				"Ventricular Standstill", "Verterbral Disc Inflammation", "Vestibular Disease", "Vitamin D Poisoning",
				"Vomiting of Blood (Hematemesis)", "Vomiting with Bile", "Wart Virus", "Water Diabetes",
				"Water Mold Infection (Pythiosis)", "Water on the Brain", "Watery Eyes",
				"Weak Immune System due to Hereditary Disorder", "Weight Loss and Chronic Disease", "Whipworms",
				"Wolff-Parkinson-White Syndrome", "Xanthine Urinary Tract Stones", "Yeast Infection and Thrush",
				"Yellow Skin (Jaundice)", "Zika Virus and Pets", "Zinc Poisoning", "Abnormal Development of the Elbow",
				"Abnormal Eyelid", "Abnormal Growths in the Lower Intestines of ", "Abnormal Heart Rhythm",
				"Abnormal Molar Development", "Abnormal Passage Between Artery and Vein",
				"Abnormal Passageway Between the Mouth and Nasal Cavity", "Abnormal Protein Production",
				"Abnormal Urine Outflow Due to Urinary Bladder Dysfunction", "Abortion", "Abscesses",
				"Accumulation of Air Between Chest and Lungs", "Acid Reflux", "Acne", "Acute (Sudden) Dog Diarrhea",
				"Acute Respiratory Distress Syndrome (ARDS)", "Acute Vomiting", "Addison’s Disease", "Adenovirus 1",
				"Adrenal Gland Cancer (Pheochromocytoma)", "Adverse Reaction to Glow Stick Jewelry",
				"Aggression (Overview)", "Aggression Toward Familiar People", "Allergic Shock", "Ameba Infection",
				"Amphetamine Poisoning", "Anaerobic Bacterial Infections", "Anal Gland Cancer", "Anal Sac Disorders",
				"Anemia (Methemoglobinemia)", "Anemia Due to Bone Marrow Failure (or Toxicity)",
				"Anemia Due to Chronic Kidney Disease", "Anemia Due to Deformed Red Blood Cells",
				"Anemia Due to Enlarged Blood Cells", "Anemia Due to Iron Deficiency",
				"Anemia Related to the Immune System", "Anemia", "Anemia", "Antibiotic-resistant Bacterial Infections",
				"Antibiotic-Resistant Infections", "Antibodies that Attack Blood Cells at Lower Temperatures",
				"Anticoagulant Poisoning", "Antifreeze Poisoning", "Antifreeze Poisoning",
				"Anxiety and Compulsive Disorders", "Are Lilies Poisonous to ?",
				"Are Onions and Garlic Bad For Your Dog?", "Arrhythmias after Blunt Heart Trauma", "Arsenic Poisoning",
				"Artery Inflammation", "Arthritis (Septic)", "Arthritis of Multiple Joints", "Aspirin Poisoning",
				"Atopic Dermatitis", "Bacterial Infection (Actinomycosis)", "Bacterial Infection (Campylobacteriosis)",
				"Bacterial Infection (Leptospirosis)", "Bacterial Infection (Metritis) of the Uterus",
				"Bacterial Infection (Mycoplasma", "Bacterial Infection (Nocardiosis)",
				"Bacterial Infection (Pyelonephritis) of the Kidneys", "Bacterial Infection (Streptococcus)",
				"Bacterial Infection (Tularemia)", "Bacterial Infection (Tyzzer Disease)",
				"Bacterial Infection of the Breast", "Bad Breath (Chronic)",
				"Baldness and Hormone-Related Skin Disorders", "Bartonella Infection", "Bile Duct Cancer",
				"Bile Duct Obstruction", "Birth Difficulties", "Black Widow Spider Bite Poisoning", "Black",
				"Bladder Inflammation with Polyps", "Bleeding Disorder", "Bleeding of the Retina in the Eye",
				"Bleeding Under the Skin of ", "Blind Quiet Eye", "Bloat or Stomach Dilatation",
				"Blood Clot in the Lungs", "Blood in the Chest", "Blood in the Front of the Eye", "Blood in the Urine",
				"Blood Related Deficiencies", "Blood Thickening", "Blood Transfusion Reactions",
				"Blue Skin and Mucus Membranes", "Bone Cancer (Chondrosarcoma)", "Bone Cancer (Fibrosarcoma)",
				"Bone Cancer (Hemangiosarcoma)", "Bone Cancer (Osteosarcoma)", "Bone Deformity and Dwarfism",
				"Bone Infection", "Bone Inflammation (Hypertrophic Osteodystrophy) in Puppies",
				"Bone Inflammation (Panosteitis)", "Bone Marrow Cancer (Myeloma)", "Bone Overgrowth",
				"Botflies (Maggots)", "Botulism", "Brain and Spinal Cord Inflammation (Meningoencephalomyelitis",
				"Brain and Spinal Cord Inflammation", "Brain Cell Degeneration", "Brain Disorder Due to Liver Disease",
				"Brain Inflammation Due to Parasitic Infection", "Brain Inflammation", "Brain Injury",
				"Brain Tissue Inflammation and Death (Breed Specific)", "Brain Tissue Undervelopment",
				"Brain Tumor (Astrocytoma)", "Brain Tumors", "Breast Cancer (Mammary Gland Tumors)",
				"Breathing Difficulties", "Breathing Problem in Short-Nose Breed ", "Breeding Timing",
				"Brown Recluse Spider Bite Poisoning", "Calcium Buildup in Lungs of ",
				"Calcium Deposits in the Urinary Tract", "Can  Be Allergic to Grass?", "Can  Eat Cinnamon?",
				"Can  Get High? The Dangerous Effects of Marijuana on ", "Can  Have Panic Attacks?",
				"Can Grass Kill Your Dog?", "Cancer of the Blood Vessel Cells",
				"Cancerous and Non-Cancerous Growths in a  Mouth", "Cancerous Lymphoid Cells in the Lungs of ",
				"Canine Coronavirus Infection", "Canine Herpesvirus", "Capillariasis", "Carbon Monoxide Poisoning",
				"Carcinoid Cancer", "Cardiac Arrest", "Cardiac Electrical Failure", "Cardiomyopathy in Boxer ",
				"Carnitine Deficiency", "Cataracts", "Cavities", "Chagas Disease", "Chemical Imbalance of Urine",
				"Chest Bone Deformity", "Chocolate Poisoning", "Chronic Inflammation of the Anus",
				"Chronic Inflammation of the Bronchi", "Chronic Vomiting", "Cirrhosis and Fibrosis of the Liver",
				"Claw and Nail Disorders", "Cleft Palate", "Clotting Deficiency (Inherited)",
				"Clotting Deficiency (Liver Related)", "Clotting Disorders of the Platelets",
				"Collapse During Exercise in Labrador Retrievers", "Collapse of the Wind Pipe",
				"Collection of Fluid in the Lungs (Not Due to Heart Disease)", "Collie Eye Defect",
				"Colonic or Rectal Inflammation", "Colonic Ulcer", "Conditions Due to Abnormal Secretions from a Tumor",
				"Congenital Heart Defect (Atrial Septal Defect)", "Congenital Heart Defect (Ebstein’s Anomaly)",
				"Congenital Heart Defect (Pulmonic Stenosis)", "Conjunctivitis (Pink Eye)", "Constipation (Severe)",
				"Constipation", "Coonhound Paralysis", "Coral Snake Bite Poisoning", "Corneal Disease (Inherited)",
				"Corneal Inflammation (Nonulcerative Keratitis)", "Coughing", "Cushings Disease", "Cyst on the Gums",
				"Defect of the Ventricular Septum", "Degeneration of the Cerebellum of the Brain",
				"Degeneration of the Cornea", "Degeneration of the Image Forming Part of the Eye",
				"Degeneration of the Iris in the Eye", "Degenerative Joint Disease",
				"Degenerative Skin Disorder (Necrolytic Dermatitis)", "Demodectic Mange",
				"Destruction of the Pituitary Gland", "Destructive Behavior", "Diabetes (Hepatopathy)", "Diabetes",
				"Diabetes with Coma", "Diabetes with Ketone Bodies", "Diarrhea (Long-term)",
				"Diarrhea Due to Clostridium perfringens", "Dietary Reactions" };

		Random ran = new Random();

		// pick a illness based on length of array
		String name = illness[ran.nextInt(illness.length)];

		// Return the name of the illness
		return name;

	}

	// Function to Generate Age and do not give a age == 0
	public static int generateAge() {
		int age = 0;
		while (age == 0) {
			age = (int) (Math.random() * Math.pow(10, 1));
		}
		return age;

	}

	// Function to Generate Staff Names based on the 2 arrays of First name and
	// Second name
	public static String staffNameGenerator() {

		// Array of Names (30 names)
		// Names got from :
		// http://listofrandomnames.com/
		String[] firstName = { "Marylee", "Maryanne", "Annamaria", "Manie", "Ismael", "Cleveland", "Vallie", "Jayne",
				"Adam", "Venice", "Lissette", "Loria", "Gussie", "Betsy", "Rikki", "Karyn", "Richelle", "Melodee",
				"Trudie", "Jacqualine", "Mae", "Tomeka", "Casie", "Desire", "Aurore", "Santana", "Johnie", "Jame",
				"Agustin", "Bernardo", };
		String[] secondName = { "Trudie", "Marica", "Laurice", "Caron", "Criselda", "Deonna", "Susie", "Cortez",
				"Tempie", "Milissa", "Newton", "Malvina", "Chiquita", "Edward", "Patsy", "Goldie", "Earline", "Vernice",
				"Lauretta", "Charlott", "Evelyne", "Elizebeth", "Lela", "Caprice", "Nilda", "Yesenia", "Nydia", "Bruce",
				"Estrella", "Ellena", };

		Random ran = new Random();

		// pick a Name based on length of array
		String fName = firstName[ran.nextInt(firstName.length)];
		String sName = secondName[ran.nextInt(secondName.length)];
		String name = fName + " " + sName;

		// Return the Name
		return name;

	}

	// Function to Generate Task Names
	public static String generateTask() {

		// Array of Tasks
		String[] taskList = { "Making Phone Calls", "On Hollidays", "Filling Pappers", "Making Coffe",
				"Making Appoitments", "Fixing Computters", "Helping Others", "Searching for News" };

		Random ran = new Random();

		// pick a Name based on length of array
		String task = taskList[ran.nextInt(taskList.length)];

		// Return the Name
		return task;

	}

	// Function to generate 1000 animals, 200 of each type
	public void startAnimals() {
		// For loop to generate 200 animals of each type
		for (int i = 0; i < 200; i++) {
			animals.add(new Dog(petNameGenerator(), generateAge(), medicalCondition()));
		}

		for (int i = 0; i < 200; i++) {
			animals.add(new Cat(petNameGenerator(), generateAge(), medicalCondition()));
		}

		for (int i = 0; i < 200; i++) {
			animals.add(new Bird(petNameGenerator(), generateAge(), medicalCondition()));
		}

		for (int i = 0; i < 200; i++) {
			animals.add(new Horse(petNameGenerator(), generateAge(), medicalCondition()));
		}

		for (int i = 0; i < 200; i++) {
			animals.add(new Rabbit(petNameGenerator(), generateAge(), medicalCondition()));
		}

	}

	// Function to generate the staff members
	public void startStaffMembers() {
		// For loop to generate specific number of each type of Staff
		// If more staff needed just have to increase the value
		for (int i = 0; i < 5; i++) {
			employees.add(new ITSpecialist(staffNameGenerator(), 100));
		}

		for (int i = 0; i < 5; i++) {
			employees.add(new Receptionist(staffNameGenerator(), 5));
		}

		for (int i = 0; i < 10; i++) {
			employees.add(new Veterinarian(staffNameGenerator(), 50));
		}

		for (int i = 0; i < 10; i++) {
			employees.add(new Nurse(staffNameGenerator(), 30));
		}

		for (int i = 0; i < 10; i++) {
			employees.add(new TraineeVet(staffNameGenerator(), 10));
		}
	}

	// Function to give some random tasks
	public void giveTask() {
		// For each going into the employees list and checking by the object name
		// if its matches one of the Admin Staff it add to a task list passing the
		// member and the task
		for (Employee admStaff : employees) {
			if (admStaff.getClass().getSimpleName().equals("ITSpecialist")
					|| admStaff.getClass().getSimpleName().equals("Receptionist")) {
				tasks.add(new Task(admStaff, generateTask()));
			}
		}
	}

	// Function to List all Staff Members
	public void listAllStaffMembers() {
		// Simple go into the employees array , and print all staff members
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~STAFF-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + staff.getName() + " - " + staff.getClass().getSimpleName());
			System.out.println("|> Staff-Number: " + staff.getStaffNumber());
			System.out.println("|> Salary Level: " + staff.getSalaryLevel());
		}

	}

	// Function to List staff by specific Category
	public void listStaffByCategory(int option, String staff) {
		// Go into the employees list and if it matches the selected category it prints
		// it
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~STAFF-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee categorie : employees) {
			if (categorie.getClass().getSimpleName().equals(staff)) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + categorie.getName() + " - " + categorie.getClass().getSimpleName());
				System.out.println("|> Staff-Number: " + categorie.getStaffNumber());
				System.out.println("|> Salary Level: " + categorie.getSalaryLevel());
			}
		}
	}

	// Function to List all Animals
	public void listAllAnimals() {
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~ANIMAL-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Animal animal : animals) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + animal.getName() + " - " + animal.getClass().getSimpleName());
			System.out.println("|> PET Age: " + animal.getAge());
			System.out.println("|> Medical Condition: " + animal.getMedicalCondition());
		}
	}

	// Function to List animal by specific Kind
	public void listAnimalByKind(int option, String kind) {
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~ANIMAL-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Animal animal : animals) {
			if (animal.getClass().getSimpleName().equals(kind)) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + animal.getName() + " - " + animal.getClass().getSimpleName());
				System.out.println("|> PET Age: " + animal.getAge());
				System.out.println("|> Medical Condition: " + animal.getMedicalCondition());
			}
		}
	}

	// Function to List Staff by specific Name
	public void listStaffByName() {
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String staffName = null;

		// Output, list all the staff and show just the names
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~NAMES-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + staff.getName());
		}

		// try catch to get the name from the user
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Staff Name:_ ");
			staffName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#~~~~~~~~~~~~~~~~~~~FOUNDED-STAFF~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			// for each reading all the array again , and if the name matches it print (if
			// the name repeats it print as many times it repeat)
			if (staffName.equals(staff.getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + staff.getName() + " - " + staff.getClass().getSimpleName());
				System.out.println("|> Staff-Number: " + staff.getStaffNumber());
				System.out.println("|> Salary Level: " + staff.getSalaryLevel());
			}

		}
	}

	// Function to List Animal by specific Name
	public void listAnimalByName() {
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String animalName = null;

		// Output, list all the staff and show just the names
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~PET-NAMES~~~~~~~~~~~~~~~~~~~~~~#");
		for (Animal animal : animals) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + animal.getName());
		}

		// try catch to get the name from the user
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the PET Name:_ ");
			animalName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#~~~~~~~~~~~~~~~~~~~FOUNDED-PET~~~~~~~~~~~~~~~~~~~~~~#");
		for (Animal animal : animals) {
			// for each reading all the array again , and if the name matches it print (if
			// the name repeats it print as many times it repeat)
			if (animalName.equals(animal.getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + animal.getName() + " - " + animal.getClass().getSimpleName());
				System.out.println("|> PET Age: " + animal.getAge());
				System.out.println("|> Medical Condition: " + animal.getMedicalCondition());
			}

		}

	}

	// Function to list Staff performing certain task
	public void listByTask() {
		String option = null;
		;
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("#~~~~~~~~~~~~~~~~~~~~~TASK-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Task task : tasks) {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.println("|> " + task.getTask());
		}

		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Task name:_ ");
			option = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#~~~~~~~~~~~~~~~~~~~FOUNDED-TASK~~~~~~~~~~~~~~~~~~~~~#");
		for (Task taskName : tasks) {
			if (taskName.getTask().equals(option)) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> Staff Name: " + taskName.getStaff().getName());
				System.out.println("|> Staff Position: " + taskName.getStaff().getClass().getSimpleName());
				System.out.println("|> Task: " + taskName.getTask());
			}

		}
	}

	// Function to assign an animal to a veterinarian
	public void assignTreatment() {
		int countAnimals = 0;

		for (Employee vet : employees) {
			if (vet.getClass().getSimpleName().equals("Veterinarian")) {
				vets.add(vet);
			}
		}

		// For each to give 100 animals for each veterinarian
		// TO IMPLEMENT! - > Find a way to give the animals randomly
		for (Animal ani : animals) {
			if (countAnimals < 100) {
				if (ani.getClass().getSimpleName().equals("Dog")) {
					treatments.add(new Treatment(vets.get(0), ani));
				}
			} else if (countAnimals > 100 && countAnimals < 200) {
				if (ani.getClass().getSimpleName().equals("Dog")) {
					treatments.add(new Treatment(vets.get(1), ani));
				}
			} else if (countAnimals > 200 && countAnimals < 300) {
				if (ani.getClass().getSimpleName().equals("Cat")) {
					treatments.add(new Treatment(vets.get(2), ani));
				}
			} else if (countAnimals > 300 && countAnimals < 400) {
				if (ani.getClass().getSimpleName().equals("Cat")) {
					treatments.add(new Treatment(vets.get(3), ani));
				}
			} else if (countAnimals > 400 && countAnimals < 500) {
				if (ani.getClass().getSimpleName().equals("Bird")) {
					treatments.add(new Treatment(vets.get(4), ani));
				}
			} else if (countAnimals > 500 && countAnimals < 600) {
				if (ani.getClass().getSimpleName().equals("Bird")) {
					treatments.add(new Treatment(vets.get(5), ani));
				}
			} else if (countAnimals > 600 && countAnimals < 700) {
				if (ani.getClass().getSimpleName().equals("Horse")) {
					treatments.add(new Treatment(vets.get(6), ani));
				}
			} else if (countAnimals > 700 && countAnimals < 800) {
				if (ani.getClass().getSimpleName().equals("Horse")) {
					treatments.add(new Treatment(vets.get(7), ani));
				}
			} else if (countAnimals > 800 && countAnimals < 900) {
				if (ani.getClass().getSimpleName().equals("Rabbit")) {
					treatments.add(new Treatment(vets.get(8), ani));
				}
			} else if (countAnimals > 900 && countAnimals < 1000) {
				if (ani.getClass().getSimpleName().equals("Rabbit")) {
					treatments.add(new Treatment(vets.get(9), ani));
				}
			}
			countAnimals++;
		}

	}

	// Function to List Animal to be treated by specific Vet
	public void listAnimalsFromVet() {
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String vetName = null;
		int positionQueue = 0;

		// Output, list all the VET and show just the names
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~VET-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			if (staff.getClass().getSimpleName().equals("Veterinarian")) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + staff.getName());
			}
		}

		// try catch to get the name from the user
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Veterinarian Name:_ ");
			vetName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("#~~~~~~~~~~~~~~~~~~FOUNDED-ANIMALS~~~~~~~~~~~~~~~~~~~~#");
		for (Treatment animalToTreat : treatments) {
			// for each reading all the array again , and if the name matches it print (if
			// the name repeats it print as many times it repeat)

			if (vetName.equals(animalToTreat.getVet().getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> PET Name: " + animalToTreat.getAnimalToHeal().getName());
				System.out.println("|> PET Age: " + animalToTreat.getAnimalToHeal().getAge());
				System.out.println("|> PET Condition: " + animalToTreat.getAnimalToHeal().getMedicalCondition());
				System.out.println("|> PET Position in the QUEUE: " + positionQueue);
			}
			positionQueue++;
		}
	}

	// Function to Treat Animals and remove them from the List
	public void treatAnimal() {
		// BufferedReader to receive data from the user Keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String vetName = null;
		String petName = null;

		// Output, list all the VET and show just the names
		System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~VET-LIST~~~~~~~~~~~~~~~~~~~~~~#");
		for (Employee staff : employees) {
			if (staff.getClass().getSimpleName().equals("Veterinarian")) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> " + staff.getName());
			}
		}

		// try catch to get the name from the user
		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Veterinarian Name:_ ");
			vetName = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("#~~~~~~~~~~~~~~~~~~FOUNDED-ANIMALS~~~~~~~~~~~~~~~~~~~~#");
		for (Treatment animalToTreat : treatments) {
			// for each reading all the array again , and if the name matches it print (if
			// the name repeats it print as many times it repeat)

			if (vetName.equals(animalToTreat.getVet().getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> PET Name: " + animalToTreat.getAnimalToHeal().getName());
				System.out.println("|> PET Age: " + animalToTreat.getAnimalToHeal().getAge());
				System.out.println("|> PET Condition: " + animalToTreat.getAnimalToHeal().getMedicalCondition());
			}
		}

		try {
			System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
			System.out.print("|> Enter the Animal Name:_ ");
			petName = reader.readLine();
		} catch (IOException | ConcurrentModificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Treatment animalToTreat : treatments) {
			// for each reading all the array again , and if the name matches it remove the
			// animal from the list

			if (petName.equals(animalToTreat.getAnimalToHeal().getName())) {
				System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
				System.out.println("|> PET Name: " + animalToTreat.getAnimalToHeal().getName());
				System.out.println("|> Sucessfully Treated!");
				// where i remove the related animal
				treatments.remove(animalToTreat);
			}
		}

	}
}
