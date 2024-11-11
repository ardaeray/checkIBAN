This repository provides a simple Java-based solution to validate International Bank Account Numbers (IBANs) according to the ISO 13616 standard. The program ensures an IBAN’s validity by verifying its structure, converting it into a numerical form, and calculating a modulus to confirm its authenticity.


Steps for IBAN Validation


1. Rearrange IBAN Format

	•	Move the first four characters of the IBAN (the country code and the two check digits) to the end of the IBAN. This rearrangement helps prepare it for the modulus calculation.
	•	Example: For an IBAN like TR120006100519786457841301, moving the first four characters to the end results in: 0006100519786457841301TR12.


2. Convert Letters to Numeric Form

	•	Convert each letter in the IBAN to its corresponding numeric value. According to the IBAN standard, each letter is represented by a two-digit number (A = 10, B = 11, …, Z = 35).
	•	Continuing with our example:
	•	Convert T to 29 and R to 27.
	•	After conversion, the IBAN becomes a fully numeric string:
	•	0006100519786457841301292712.


3. Remove Leading Zeros

	•	Trim any leading zeros in the numeric IBAN to simplify the modulus calculation.
	•	In this case, the numeric IBAN becomes: 6100519786457841301292712.


4. Calculate Modulus 97

	•	To avoid large integer issues, calculate the modulus step-by-step:
	•	Start with an initial remainder of 0.
	•	For each digit in the numeric IBAN string:
	•	Update the remainder by multiplying it by 10 and adding the current digit.
	•	Take the modulus of the result with 97 after each step.
	•	If the final remainder is 1, the IBAN is valid; otherwise, it is invalid.


Example Output:


Enter your IBAN Number here: TR120006100519786457841301

This IBAN is invalid!

----------------------------------------------------------------------------------------

Enter your IBAN Number here: TR330006100519786457841326

This IBAN is valid!