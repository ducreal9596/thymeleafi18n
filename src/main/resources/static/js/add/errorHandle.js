const $ = document.querySelector.bind(document);
const form = $("#register-form")
const forms = Array.from(form.getElementsByClassName("error"));
const inputAndSelectFields = Array.from(form.querySelectorAll("input:not([type='radio'], [type='hidden'], [type='checkbox'])"));
inputAndSelectFields.forEach((field, index) => {
	field.addEventListener("focus", () => {
		const errorElement = forms[index];
		errorElement.textContent = "";
	});
	field.addEventListener("blur", () => {
		const value = field.value.trim();
		const errorElement = forms[index];
		const regexPattern = error[index].regex;
		if (!value) {
			errorElement.textContent = error[index].message;
		} else if (regexPattern && !regexPattern.test(value)) {
			errorElement.textContent = "Invalid format";
		} else {
			errorElement.textContent = "";
		}
	});
});
const handleValidator = () => {
	let hasErrors = false;
	inputAndSelectFields.forEach((field, index) => {
		const value = field.value.trim();
		const errorElement = forms[index];
		const regexPattern = error[index].regex;
		if (!value) {
			errorElement.textContent = error[index].message;
			hasErrors = true;
		} else if (regexPattern && !regexPattern.test(value)) {
			errorElement.textContent = "Invalid format";
			hasErrors = true;
		} else {
			errorElement.textContent = "";
		}
	});
	if (!hasErrors) {
		return true;
	} else {
		return false;
	}
};
const btnAdd = $("#btn-add");
btnAdd.addEventListener("click", (e) => {
	e.preventDefault();
	if (handleValidator()) {
		form.submit();
		form.reset();
	}
});