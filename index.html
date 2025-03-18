<!DOCTYPE html>
<html>
<head>
    <title>Flappy Bird Game</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
        }
        canvas {
            background-color: skyblue;
            display: block;
            margin: auto;
        }
    </style>
</head>
<body>
    <h1>Flappy Bird</h1>
    <canvas id="gameCanvas" width="400" height="500"></canvas>
    <script>
        const canvas = document.getElementById("gameCanvas");
        const ctx = canvas.getContext("2d");

        let bird = { x: 50, y: 250, radius: 15, velocity: 0, gravity: 0.5 };
        let pipes = [];
        let score = 0;
        let isGameOver = false;

        document.addEventListener("keydown", () => {
            bird.velocity = -8;
        });

        function createPipe() {
            let gap = 120;
            let topHeight = Math.random() * (canvas.height / 2);
            let bottomHeight = canvas.height - (topHeight + gap);
            pipes.push({ x: canvas.width, topHeight, bottomHeight, width: 50 });
        }

        function update() {
            if (isGameOver) return;
            
            bird.velocity += bird.gravity;
            bird.y += bird.velocity;

            if (bird.y + bird.radius > canvas.height || bird.y - bird.radius < 0) {
                isGameOver = true;
            }

            for (let i = 0; i < pipes.length; i++) {
                pipes[i].x -= 3;
                
                if (pipes[i].x + pipes[i].width < 0) {
                    pipes.splice(i, 1);
                    score++;
                }
                
                if (
                    bird.x + bird.radius > pipes[i].x &&
                    bird.x - bird.radius < pipes[i].x + pipes[i].width &&
                    (bird.y - bird.radius < pipes[i].topHeight || bird.y + bird.radius > canvas.height - pipes[i].bottomHeight)
                ) {
                    isGameOver = true;
                }
            }
        }

        function draw() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);

            ctx.fillStyle = "yellow";
            ctx.beginPath();
            ctx.arc(bird.x, bird.y, bird.radius, 0, Math.PI * 2);
            ctx.fill();

            ctx.fillStyle = "green";
            pipes.forEach(pipe => {
                ctx.fillRect(pipe.x, 0, pipe.width, pipe.topHeight);
                ctx.fillRect(pipe.x, canvas.height - pipe.bottomHeight, pipe.width, pipe.bottomHeight);
            });

            ctx.fillStyle = "black";
            ctx.font = "20px Arial";
            ctx.fillText("Score: " + score, 10, 20);
            
            if (isGameOver) {
                ctx.fillText("Game Over!", canvas.width / 2 - 40, canvas.height / 2);
            }
        }

        function gameLoop() {
            update();
            draw();
            if (!isGameOver) {
                requestAnimationFrame(gameLoop);
            }
        }

        setInterval(createPipe, 2000);
        gameLoop();
    </script>
</body>
</html>
