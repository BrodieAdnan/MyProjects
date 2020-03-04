#include <Servo.h>

/**
   @brief Programma per la gestione di una cassaforte elettronica attraverso Arduino
   @author Casarin Alessandro, Gazi Adnan
   @date ...
*/

int led = 0;

class Cassaforte {
  public:
    Cassaforte(codeIns);
    void apri();
    void chiudi();
    void cambioCombinazione();

  private:
    int codice, tentativi;
    boolean aperta;
    Servo motore;
};

Cassaforte::Cassaforte(int codeIns) {
  codice = codeIns;
  aperta = false;
  motore.attach(9);
}
void Cassaforte::apri(int codeIns) {
  if (!aperta) {
    if (contatore == 3) {
      Serial.println("Hai sbagliato il codice 3 volte, riprova tra 10 secondi");
      for (int i = 0; i < 10; i++) {
        digitalWrite(led, HIGH);
        delay(500);
        digitalWrite(led, LOW);
        delay(500);
      }
    } else if (codeIns == codice) {
      motore.write(90);
      aperta = true;
      tentativi = 0;
    } else {
      tentativi++;
    }
  }
}
void Cassaforte::chiudi(int codeIns) {
  if (aperta) {
    if (codeIns == codice) {
      motore.write(0);
      aperta = false;
    } else {
      digitalWrite(led, HIGH);
      delay(500);
      digitalWrite(led, LOW);
      delay(500);
    }
  }
}
void Cassaforte::cambiaCombinazione(int newCode) {
  if (aperta) {
    if (newCode >= 1000 && newCode <= 9999999999) { // se è compreso tra il numero più piccolo con 4 cifre e il più grande con 10 cifre
      codice = newCode;
      digitalWrite(led, HIGH);
      delay(500);
      digitalWrite(led, LOW);
      delay(500);
    } else {
      Serial.println("Il codice non è della misura giusta, riprova");
    }
  } else {
    Serial.print("Per cambiare combinazione devi prima aprire la cassaforte");
  }

  void setup() {
    Serial.begin(9600);
    pinMode(led, OUTPUT);
  }

  void loop() {

  }
