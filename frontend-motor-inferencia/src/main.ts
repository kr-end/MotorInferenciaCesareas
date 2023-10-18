// Selecciona el elemento HTML con la clase "slide-page" y lo asume como un elemento HTML de tipo 'div'.
const slidePage = document.querySelector(".slide-page") as HTMLDivElement;

// Selecciona diferentes botones y los asume como elementos de tipo 'button'.
const nextBtnFirst: HTMLButtonElement = document.querySelector(".firstNext") as HTMLButtonElement;
const prevBtnSec = document.querySelector(".prev-1") as HTMLButtonElement;
const nextBtnSec = document.querySelector(".next-1") as HTMLButtonElement;
const prevBtnThird = document.querySelector(".prev-2") as HTMLButtonElement;
const nextBtnThird = document.querySelector(".next-2") as HTMLButtonElement;
const prevBtnFourth = document.querySelector(".prev-3") as HTMLButtonElement;
const submitBtn = document.querySelector(".submit") as HTMLButtonElement;

// Selecciona varios elementos con las clases "step p", "step .check" y "step .bullet".
const progressText = document.querySelectorAll(".step p");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");

// Inicializa una variable llamada 'current' con el valor 1.
let current = 1;

// A continuación, se agregan escuchas de eventos a los botones.

// Cuando se hace clic en el botón 'nextBtnFirst'.
nextBtnFirst.addEventListener("click", function (event) {
  event.preventDefault(); // Previene el comportamiento predeterminado del botón (por ejemplo, enviar un formulario).
  slidePage.style.marginLeft = "-25%"; // Cambia el margen izquierdo para mostrar la siguiente sección del formulario.
  bullet[current - 1].classList.add("active"); // Marca el progreso en una barra de pasos.
  progressCheck[current - 1].classList.add("active"); // Marca el progreso con un 'check'.
  progressText[current - 1].classList.add("active"); // Marca el progreso en un texto.
  current += 1; // Incrementa la variable 'current'.
});

// Los otros 'addEventListener' son similares y controlan la navegación entre secciones del formulario.

// Cuando se hace clic en el botón 'submitBtn'.
submitBtn.addEventListener("click", function () {
  bullet[current - 1].classList.add("active"); // Marca el progreso en una barra de pasos.
  progressCheck[current - 1].classList.add("active"); // Marca el progreso con un 'check'.
  progressText[current - 1].classList.add("active"); // Marca el progreso en un texto.
  current += 1; // Incrementa la variable 'current'.

  // Después de un retraso de 800 milisegundos, muestra una alerta y recarga la página.
  setTimeout(function () {
    alert("Your Form Successfully Signed up");
    location.reload();
  }, 800);
});

// Los 'prevBtnSec', 'prevBtnThird' y 'prevBtnFourth' permiten retroceder en el formulario y desmarcan el progreso en la barra de pasos y otras indicaciones visuales.
