import { Pet } from "./mission6_Pet.js";

export class PetGrowthRecord extends Pet {
	constructor(name, spec, adoptionDate, description, recordDate) {
		super(name, spec, adoptionDate);
		this.description = description;
		this.type = "Growth Record";
		this.recordDate = recordDate;
	}
}
