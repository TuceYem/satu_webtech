Projektmitglieder:

- Tuce Yemisen (s0575696)






### Repository:

https://github.com/TuceYem/satu_webtech

## Projektname:

satu_flashcards

### Projektbeschreibung:

Karteikartenmanagementsystem

###### Funktionen / Inhalte:

- Einloggen und registrieren ueber Okta

- Tab: 'Edit'

  - Frage und Antwort der Karteikarte eingeben und mit 'save' in die DB speichern.
  
  - Ueberprueft, ob Eingabe des Users 'leer' oder nur Leerzeichen beeinhaltet. Keine Speicherung andernfalls moeglich.
  
  - Loeschen der angelegten Karten durch Klick moeglich. Loescht auch in der DB.
  
  - Ueberschreiben der angelegten Karten durch Klick moeglich. Inhalt wird in dem Form Bereich geladen und statt 'save' wird 'update' Button angezeigt, der einen PUT Mapping (statt POST) ausloest (Inhalt wird geprueft, ob leer oder nur Leerzeichen, sonst kein Aenderung moeglich)

- Tab: 'Study'
  
  - Angelegte Karten aus dem tab 'Edit' werden bei jedem Browser-Refresh hier geladen.
  
  - Anzeige der zu lernenden Karten durch 'Cards remaining: ...'
  
  - 'Again' Button legt Karte zurueck und zeigt naechste Karte an (veraendert Anzahl der Karten im Lernstapel nicht)
  
  - 'Good' Button loescht Karte aus dem zu lernenden Stapel, da das nicht wiederholt werden muss (veraendert Anzahl der Karten im Lernstapel)
  
  - Wenn alle Karten fertig gelernt sind, so wird eine Nachricht angezeigt.




