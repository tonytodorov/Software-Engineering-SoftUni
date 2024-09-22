SELECT deposit_group, SUM(deposit_amount)
FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group;

SELECT * FROM wizzard_deposits;
