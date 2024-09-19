SELECT user_name, SUBSTRING_INDEX(email, '@', -1) as email FROM users
ORDER BY email, user_name;