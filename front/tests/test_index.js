// main.test.js

const validStates = new Set([
  "maine", "california", "texas", "new york", "alabama"
]);

let score = 0;
let correct = new Set();

function checkState(state) {
  const s = state.toLowerCase().trim();
  if (validStates.has(s) && !correct.has(s)) {
    correct.add(s);
    score++;
    return "correct";
  } else if (correct.has(s)) {
    return "duplicate";
  } else {
    return "invalid";
  }
}

test("Valid state gets accepted", () => {
  expect(checkState("Texas")).toBe("correct");
});

test("Duplicate state returns duplicate", () => {
  checkState("Texas");
  expect(checkState("Texas")).toBe("duplicate");
});

test("Invalid state returns invalid", () => {
  expect(checkState("Wakanda")).toBe("invalid");
});

test("Score increments correctly", () => {
  score = 0;
  correct.clear();
  checkState("California");
  checkState("New York");
  expect(score).toBe(2);
});
