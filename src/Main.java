
//Jeg har taget mig et par friheder, som at oprette Problem-klassen, som kan oprettes med eller uden CostFactors.
// Det vil også sige at i opgave 1 bliver det cost af et Problem og ikke bare hours to cost, da estimated hours nu ligger
// i Problem-objektet. Cost to hours kan også laves om til at returnere et Problem med lidt modifikationer.
// I opgave 2 har jeg lavet et interface som skabelon til CostFactors, som kan øge prisen med en eller anden procentsats.
// Jeg ved ikke hvad der er normalt at gøre, men jeg har ikke fjernet alle mine logs og alle de steder i main, hvor
// jeg opretter mine instanser og kører metoderne. Jeg har lavet nogle steder med random værdier, for at få forskellige
// resultater hver gang jeg kører. Jeg håber at jeg har besvaret opgaven.

public class Main {
    public static void main(String[] args) {
        TroubleshootingModel tModel_1 = new TroubleshootingModel("Model 1",250);
        Problem easyProblem = tModel_1.detectEasyProblem();
        Problem specialProblem = tModel_1.detectSpecialProblem();
        Converter converter = new Converter(500);
        ExtendedConverter extendedConverter = new ExtendedConverter(500, true);

        converter.simpleProblemCost(easyProblem, tModel_1);
        converter.costToHours(4700, tModel_1);
        extendedConverter.specialProblemCost(specialProblem, tModel_1);
        extendedConverter.simpleProblemCost(easyProblem, tModel_1); // virker, da klassen er extended fra Converter
        converter.simpleProblemCost(specialProblem, tModel_1); // giver en error
        extendedConverter.simpleProblemCost(specialProblem, tModel_1); // giver en error
        extendedConverter.specialProblemCost(easyProblem, tModel_1); // giver en error
    }
}
