 ```javaScritpt
 const data = [
  {notes: 'Game was played', time: '2017-10-04T20:24:30+00:00', sport: 'hockey', owner: 'steve', players: '10', game_id: 1},
  { notes: 'Game was played', time: '2017-10-04T12:35:30+00:00', sport: 'lacrosse', owner: 'steve', players: '6', game_id: 2 },
  { notes: 'Game was played', time: '2017-10-14T20:32:30+00:00', sport: 'hockey', owner: 'steve', players: '4', game_id: 3 },
  { notes: 'Game was played', time: '2017-10-04T10:12:30+00:00', sport: 'hockey', owner: 'henry', players: '10', game_id: 4 },
  { notes: 'Game was played', time: '2017-10-14T20:34:30+00:00', sport: 'soccer', owner: 'john', players: '12', game_id: 5 }
];

// this gives an object with dates as keys
const groups = data.reduce((groups, game) => {
  const date = game.time.split('T')[0];
  if (!groups[date]) {
    groups[date] = [];
  }
  groups[date].push(game);
  return groups;
}, {});

// Edit: to add it in the array format instead
const groupArrays = Object.keys(groups).map((date) => {
  return {
    date,
    games: groups[date]
  };
});

console.log(groupArrays);
```
参考：https://stackoverflow.com/questions/46802448/how-do-i-group-items-in-an-array-by-date
