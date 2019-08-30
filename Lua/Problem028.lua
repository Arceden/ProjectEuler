-- Declare
local sum, size, last, n;

-- Initialize
size = 1001;
sum = 0;
last = 0;

-- Modify
size = math.ceil(size / 2);

-- Loop for every spiral
for i=0, size-1, 1 do
    if i == 0 then
        n = 1;
    else
        n = i * 8;
    end

    -- Obtain all numbers in the current spiral
    for x=0, n-1, 1 do
        last = last + 1;
        
        -- Use modulo to obtain all 4 diagonal corners of the spiral
        if n == 1 or (x-((n/2)-1)) % (n/4) == 0 then
            sum = sum + last;
        end
    end
end

print("Sum: ", sum);