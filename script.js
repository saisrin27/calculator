const display = document.getElementById('display');
let num1 = 0, num2 = 0, result = 0;
let operator = '';
let resetDisplay = false;

document.querySelectorAll('button').forEach(button => {
  button.addEventListener('click', () => {
    const input = button.textContent;

    if (!isNaN(input) || input === '.') {
      if (resetDisplay) {
        display.value = '';
        resetDisplay = false;
      }
      display.value += input;
    } else if (input === 'C') {
      display.value = '';
      num1 = num2 = result = 0;
      operator = '';
    } else if (input === '=') {
      if (operator && display.value) {
        num2 = parseFloat(display.value);
        switch (operator) {
          case '+': result = num1 + num2; break;
          case '-': result = num1 - num2; break;
          case '*': result = num1 * num2; break;
          case '/': result = num2 !== 0 ? num1 / num2 : 'Error'; break;
        }
        display.value = result;
        resetDisplay = true;
      }
    } else {
      num1 = parseFloat(display.value);
      operator = input;
      resetDisplay = true;
    }
  });
});
