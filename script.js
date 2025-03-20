document.addEventListener("DOMContentLoaded", function () {
    const board = document.getElementById("ludoBoard");

    // Generate 15x15 Ludo grid
    for (let i = 0; i < 225; i++) {
        let cell = document.createElement("div");
        cell.classList.add("cell");
        board.appendChild(cell);
    }
});

let currentPlayer = 'red';
let diceRoll = 0;

function rollDice() {
    diceRoll = Math.floor(Math.random() * 6) + 1;
    document.getElementById("diceResult").innerText = `🎲 Rolled: ${diceRoll}`;

    movePlayer(currentPlayer, diceRoll);
    switchTurn();
}

function movePlayer(player, steps) {
    alert(`${player} moves ${steps} steps!`);
}

function switchTurn() {
    const players = ['red', 'blue', 'green', 'yellow'];
    let index = players.indexOf(currentPlayer);
    currentPlayer = players[(index + 1) % players.length];

    document.getElementById("diceResult").innerText = `🎲 ${currentPlayer}'s turn!`;
}
