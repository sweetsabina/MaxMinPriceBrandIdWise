# MaxMinPriceBrandIdWise
Pay pay securities coding test question.

**Input**
Given an array of strings like below,
brandid,price

APY,170.00
APY,185.00
AMZ,145.00
APY,130.00
AMZ,124.00
AMZ,115.00
APY,140.00

where APY is brand id, followed by the price of that brand id.

**Output**
An array of strings with unique brand id in dictionary order
brandId,firstPrice,maxPrice,minPrice,lastPrice

AMZ,145.00,145.00,115.00,115.00
APY,170.00,185.00,130.00,140.00
