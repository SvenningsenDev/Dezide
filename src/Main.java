
//Jeg har taget mig et par friheder, som at oprette Problem-klassen, som kan oprettes med eller uden CostFactors.
// Det vil også sige at i opgave 1 bliver det cost af et Problem og ikke bare hours to cost, da estimated hours nu ligger
// i Problem-objektet. Cost to hours kan også laves om til at returnere et Problem med lidt modifikationer.
// I opgave 2 har jeg lavet et interface som skabelon til CostFactors, som kan øge prisen med en eller anden procentsats.
// Da der nu er 2 forskellige problemer (simple & special) kunne man evt oprette en slags converter factory eller lignende,
// som opretter en converter baseret på hvordan problemet ser ud, i stedet for hvordan det gøres nu, såfremt at der i fremtiden
// eventuelt kunne komme flere typer problemer, som skal håndteres på nye måder.
// Jeg ved ikke hvad der er normalt at gøre, men jeg har ikke fjernet alle mine logs og alle de steder i main, hvor
// jeg opretter mine instanser og kører metoderne. Jeg har lavet nogle steder med random værdier, for at få forskellige
// resultater hver gang jeg kører. Jeg håber at jeg har besvaret opgaven.

public class Main {
    public static void main(String[] args) {
        TroubleshootingModel tModel_1 = new TroubleshootingModel("Model 1",250);
        Problem simpleProblem = tModel_1.detectSimpleProblem();
        Problem specialProblem = tModel_1.detectSpecialProblem();
        Converter converter = new Converter(500);
        ExtendedConverter extendedConverter = new ExtendedConverter(500, false);

        double cost1 = converter.simpleProblemCost(simpleProblem, tModel_1);
        double hours1 = converter.costToHours(4700, tModel_1);
        double cost2 = extendedConverter.specialProblemCost(specialProblem, tModel_1);
        double cost3 = extendedConverter.simpleProblemCost(simpleProblem, tModel_1); // virker, da klassen er extended fra Converter
        // double errorcost1 = converter.simpleProblemCost(specialProblem, tModel_1); // giver en error
        // double errorcost2 = extendedConverter.simpleProblemCost(specialProblem, tModel_1); // giver en error
        // double errorcost3 = extendedConverter.specialProblemCost(simpleProblem, tModel_1); // giver en error

        System.out.println("Cost 1 with the simple problem and the simple converter is: " + cost1);
        System.out.println("Given the cost, the amount of hours spent is: " + hours1);
        System.out.println("Cost 2 with the special problem and the special converter is: " + cost2);
        System.out.println("Cost 3 with the simple problem and the special converter is: " + cost3);
    }
}
