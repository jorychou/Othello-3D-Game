1. Varför triggas inte bindings för .selectedToggleProperty() automatiskt i
   ConfigDialog.setupBindings() när man klickar på en annan radioknapp? Det
   måste vi ta reda på!

2. Till den som läser detta: Anmärk gärna på programmets arkitekturella
   struktur. Vilka dåliga designval har vi gjort? Vilka bra val har vi gjort?
   Är arkitekturen gångbar i arbetslivet? Osv osv. Tack. :-)

3. Vi använder inte primaryStage som JavaFX skickar med 'by default'. Är det en
   dålig idé att göra så? Behöver vi ens ärva från Application om vi inte vill
   ha primaryStage?

4. Jag vet att indenteringen i mina (Philips) klasser är felaktig. Jag
   indenterar inte den yttersta nivån direkt inuti klassen. Då ALL kod i Java
   ligger inuti klasser så är den nivån syntaktiskt självklar och behövs inte
   indenteras. Dvs, alla mina metoder ligger längst ut mot marginalen trots att
   de ligger inuti klassens 'måsvingar'. Därav sparar man 4 tecken i bredd på
   varje rad. Fantastiskt! Tankar om detta? :-) 
   //Martin instämmer i resonemanget och gör likadant.
