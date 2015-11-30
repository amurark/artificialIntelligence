attribute(income, [low, medium, high]).
attribute(history, [good, bad, unknown]).
attribute(debt, [low, high]).
attribute(collateral, [none, adequate]).

example(high, [income = low, history = good, debt = low, collateral = none]).
example(high, [income = low, history = good, debt = low, collateral = adequate]).
example(high, [income = low, history = good, debt = high, collateral = none]).
example(high, [income = low, history = good, debt = high, collateral = adequate]).

example(high, [income = low, history = bad, debt = low, collateral = none]).
example(high, [income = low, history = bad, debt = low, collateral = adequate]).
example(high, [income = low, history = bad, debt = high, collateral = none]).
example(high, [income = low, history = bad, debt = high, collateral = adequate]).

example(high, [income = low, history = unknown, debt = low, collateral = none]).
example(high, [income = low, history = unknown, debt = low, collateral = adequate]).
example(high, [income = low, history = unknown, debt = high, collateral = none]).
example(high, [income = low, history = unknown, debt = high, collateral = adequate]).


example(high, [income = medium, history = bad, debt = low, collateral = none]).
example(high, [income = medium, history = bad, debt = low, collateral = adequate]).
example(high, [income = medium, history = bad, debt = high, collateral = none]).
example(high, [income = medium, history = bad, debt = high, collateral = adequate]).



example(high, [income = medium, history = unknown, debt = high, collateral = none]).
example(high, [income = medium, history = unknown, debt = high, collateral = adequate]).


example(moderate, [income = medium, history = good, debt = low, collateral = none]).
example(moderate, [income = medium, history = good, debt = low, collateral = adequate]).
example(moderate, [income = medium, history = good, debt = high, collateral = none]).
example(moderate, [income = medium, history = good, debt = high, collateral = adequate]).



example(moderate, [income = medium, history = unknown, debt = low, collateral = none]).
example(moderate, [income = medium, history = unknown, debt = low, collateral = adequate]).


example(moderate, [income = high, history = bad, debt = low, collateral = none]).
example(moderate, [income = high, history = bad, debt = low, collateral = adequate]).
example(moderate, [income = high, history = bad, debt = high, collateral = none]).
example(moderate, [income = high, history = bad, debt = high, collateral = adequate]).


example(low, [income = high, history = good, debt = low, collateral = none]).
example(low, [income = high, history = good, debt = low, collateral = adequate]).
example(low, [income = high, history = good, debt = high, collateral = none]).
example(low, [income = high, history = good, debt = high, collateral = adequate]).



example(low, [income = high, history = unknown, debt = low, collateral = none]).
example(low, [income = high, history = unknown, debt = low, collateral = adequate]).
example(low, [income = high, history = unknown, debt = high, collateral = none]).
example(low, [income = high, history = unknown, debt = high, collateral = adequate]).


