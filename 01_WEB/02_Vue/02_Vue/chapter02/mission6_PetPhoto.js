import { Pet } from "./mission6_Pet.js";

export class PetPhoto extends Pet {
	constructor(name, spec, adoptionDate, photoPath) {
		super(name, spec, adoptionDate);
		this.photoPath = photoPath;
		this.type = "Photo";
		this.uploadDate = new Date();
	}
}
