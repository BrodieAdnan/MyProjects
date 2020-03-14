#include <Keypad.h>
#include <Servo.h>

/**
   @brief Programma per la gestione di una cassaforte elettronica attraverso Arduino
   @author Casarin Alessandro, Gazi Adnan
   @date ...
*/

int led = 10;
int pos = 0;

const byte ROWS = 4; // Quattro righe
const byte COLS = 4; // Quattro colonne
char keys[ROWS][COLS] = { // Definizione mappa della tastiera
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};
byte rowPins[ROWS] = {
  0, 2, 3, 4
}; // Connessione delle righe: Riga0, Riga1, Riga2 e Riga3 ai pins di Arduino.
byte colPins[COLS] = {
  5, 6, 7, 8
}; // Connessione delle colonne: Colonna0, Colonna1 , Colonna2 e Colonna3 ai pins di Arduino.
Keypad tastiera = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS ); // Creazione della tastiera

Servo motore;

class Cassaforte {
  public:

    Cassaforte(String codeIns);
    void apri();
    void chiudi();
    void cambiaCombinazione();

  private:

    String codice;
    int tentativi;
    boolean aperta;
    void accendiLed(int n);
    void apriConServo();
    void chiudiConServo();

};

Cassaforte::Cassaforte(String codeIns) {
  codice = codeIns;
  aperta = false; // la cassaforte viene creata chiusa
  tentativi = 0;
  for (pos = motore.read(); pos >= 0; pos --) { // imposto l'angolo del servomotore a 0 gradi
    motore.write(pos);
    delay(15);
  }
}

void Cassaforte::apri() {
  if (!aperta) {
    String codeIns = "";
    boolean fine = false;
    while (!fine) {
      char c = tastiera.getKey();
      if (c != '*') {
        codeIns += c;
      } else {
        fine = true;
      }
    }
    if (codeIns.equals(codice)) {
      apriConServo();
      aperta = true;
      tentativi = 0;
    } else {
      tentativi++;
      if (tentativi == 3) {
        tentativi = 0;
        Serial.println("Hai sbagliato il codice 3 volte, riprova tra 10 secondi");
        tastiera.setDebounceTime(10000);
        accendiLed(10);
      } else {
        accendiLed(2);
      }
    }
  }
}

void Cassaforte::chiudi() {
  if (aperta) {
    String codeIns = "";
    boolean fine = false;
    while (!fine) {
      char c = tastiera.getKey();
      if (c != '*') {
        codeIns += c;
      } else {
        fine = true;
      }
    }
    if (codeIns.equals(codice)) {
      chiudiConServo();
      aperta = false;
    } else {
      accendiLed(2);
    }
  }
}

void Cassaforte::cambiaCombinazione() {
  if (aperta) {
    String newCode = "";
    boolean fine = false;
    while (!fine) {
      char c = tastiera.getKey();
      if (c != '*') {
        newCode += c;
      } else {
        fine = true;
      }
    }
    if (newCode.length() >= 4 && newCode.length() <= 10) {
      codice = newCode;
      accendiLed(2);
    } else {
      Serial.println("Il codice non è della misura giusta, riprova");
    }
  } else {
    Serial.print("Per cambiare combinazione devi prima aprire la cassaforte");
  }
}

void Cassaforte::accendiLed(int n) {
  for (int i = 0; i < n; i++) {
    digitalWrite(led, HIGH);
    delay(500);
    digitalWrite(led, LOW);
    delay(500);
  }
}

void Cassaforte::apriConServo() {
  for (; pos <= 90; pos ++) {
    motore.write(pos);
    delay(15);
  }
}

void Cassaforte::chiudiConServo() {
  for (; pos >= 0; pos --) {
    motore.write(pos);
    delay(15);
  }
}

Cassaforte c("1234");

void setup() {
  Serial.begin(9600);
  pinMode(led, OUTPUT);
  motore.attach(9);
}

void loop() {
  char key = tastiera.getKey();
  if (key) // controlla che il valore sia valido.
  {
    switch (key)
    {
      case 'A':
        c.apri();
        break;
      case 'C':
        c.chiudi();
        break;
      case '#':
        c.cambiaCombinazione();
        break;
      default:
        Serial.println("Carattere non accettabile");
    }
  }
}
