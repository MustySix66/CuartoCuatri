bool bandera = true;
TaskHandle_t Tarea1; // Para manejar la tarea1
TaskHandle_t Tarea2; // Para manejar la tarea2

// Pines de los LEDs
const int led1 = 2;
const int led2 = 4;
const int led3 = 12;
const int led4 = 14;

void setup() {
  Serial.begin(115200);
  delay(1000);
  Serial.print("Setup() se corre en el nucleo: ");
  Serial.println(xPortGetCoreID());

  // Configuración de pines como salida
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);

  // Crear tarea1 para el núcleo 0
  xTaskCreatePinnedToCore(
      loop_tarea1,  /* Función de la tarea */
      "Tarea1",     /* Nombre de la tarea */
      10000,        /* Tamaño de la pila */
      NULL,         /* Parámetros de entrada */
      1,            /* Prioridad de la tarea */
      &Tarea1,      /* Objeto TaskHandle_t */
      0);           /* Núcleo donde se correrá */

  // Crear tarea2 para el núcleo 1
  xTaskCreatePinnedToCore(
      loop_tarea2,  /* Función de la tarea */
      "Tarea2",     /* Nombre de la tarea */
      10000,        /* Tamaño de la pila */
      NULL,         /* Parámetros de entrada */
      1,            /* Prioridad de la tarea */
      &Tarea2,      /* Objeto TaskHandle_t */
      1);           /* Núcleo donde se correrá */
}

void loop() {
  // Este código no es necesario para FreeRTOS, ya que todo se gestiona en las tareas
  if (bandera) {
    Serial.print("Loop() se corre en el nucleo: ");
    Serial.println(xPortGetCoreID());
    bandera = false;
  }
}

// Tarea 1: Maneja los LEDs 1 y 2 en el núcleo 0
void loop_tarea1(void *pvParameters) {
  Serial.println("Tarea1 se corre en el nucleo: ");
  Serial.println(xPortGetCoreID());
 
  while (1) {
    digitalWrite(led1, HIGH);
    digitalWrite(led2, LOW);
    delay(50);
    digitalWrite(led1, LOW);
    digitalWrite(led2, HIGH);
    delay(20);
  }
}

// Tarea 2: Maneja los LEDs 3 y 4 en el núcleo 1
void loop_tarea2(void *pvParameters) {
  Serial.println("Tarea2 se corre en el nucleo: ");
  Serial.println(xPortGetCoreID());
  while (1) {
    digitalWrite(led3, HIGH);
    digitalWrite(led4, LOW);
    delay(150);
    digitalWrite(led3, LOW);
    digitalWrite(led4, HIGH);
    delay(150);
  }
}