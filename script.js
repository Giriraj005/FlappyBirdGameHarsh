// 🟢 Initialize Game
let players = ["red", "blue", "green", "yellow"];
let currentPlayer = 0;
let diceRoll = 0;
let positions = { red: 0, blue: 0, green: 0, yellow: 0 };

// 🎲 Roll Dice Function
function rollDice() {
    diceRoll = Math.floor(Math.random() * 6) + 1;
    document.getElementById("diceResult").innerText = `🎲 Rolled: ${diceRoll}`;
    movePlayer(players[currentPlayer], diceRoll);
}

// 🚀 Move Player
function movePlayer(player, steps) {
    positions[player] += steps; // Move forward

    // 🔹 Update Player Position on Board
    updateBoard();

    // ⏩ Switch Turn
    switchTurn();
}

// 🔄 Switch Turn
function switchTurn() {
    currentPlayer = (currentPlayer + 1) % players.length;
    document.getElementById("turnIndicator").innerText = `🔄 Now it's ${players[currentPlayer]}'s turn!`;
}

// 🎯 Update Ludo Board UI
function updateBoard() {
    let cells = document.querySelectorAll(".cell");
    cells.forEach(cell => cell.innerHTML = ""); // Clear previous positions

    for (let player in positions) {
        let pos = positions[player];
        if (pos < cells.length) {
            cells[pos].innerHTML = `<div class="player ${player}"></div>`; // Show player
        }
    }
}

// 🌟 Initialize Board Grid
function createBoard() {
    let board = document.getElementById("ludoBoard");
    for (let i = 0; i < 100; i++) {
        let cell = document.createElement("div");
        cell.classList.add("cell");
        board.appendChild(cell);
    }
}

// 🔥 Start the Game
window.onload = function () {
    createBoard();
    document.getElementById("turnIndicator").innerText = `🎲 Roll to Start!`;
};
