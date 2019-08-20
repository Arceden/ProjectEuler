-- First attempt in using Lua
-- If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
--  The sum of these multiples is 23.
-- Find the sum of all the multiples of 3 or 5 below 1000.

-- Declare
local limit, sum;

-- Initialize
limit = 1000;
sum = 0;

-- Loop as long as _i_ is below _limit_
for i=1, limit-1, 1 do
    -- Check if _i_ is a multiple of 3 or 5
    if (i % 3 == 0) or (i % 5 == 0) then
        sum = sum + i
    end
end

-- Print result
print(sum)