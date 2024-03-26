/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.niloy.samples.test;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.niloy.samples.Entities.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;


@Controller
@RequiredArgsConstructor
class OwnerController {

	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

	//private final OwnerRepository owners;
	private final AuthenticationManager authenticationManager;
	private final SecurityContextRepository securityContextRepository;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

//	@ModelAttribute("owner")
//	public Owner findOwner(@PathVariable(name = "ownerId", required = false) Integer ownerId) {
//		return ownerId == null ? new Owner() : this.owners.findById(ownerId);
//	}

//	@GetMapping("/owners/new")
//	public String initCreationForm(Map<String, Object> model) {
//		Owner owner = new Owner();
//		model.put("owner", owner);
//		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//	}
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String p,
						HttpServletRequest req, HttpServletResponse res){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username,p)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContextRepository.saveContext(securityContext,req,res);

		return  "welcome";
	}

//	@PostMapping("/owners/new")
//	public String processCreationForm(@Valid Owner owner, BindingResult result) {
//		if (result.hasErrors()) {
//			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//		}
//
//		this.owners.save(owner);
//		return "redirect:/owners/" + owner.getId();
//	}

	@GetMapping("/owners/find")
	public String initFindForm() {
		return "owners/findOwners";
	}

//	@GetMapping("/owners")
//	public String processFindForm(@RequestParam(defaultValue = "1") int page, Owner owner, BindingResult result,
//			Model model) {
//		// allow parameterless GET request for /owners to return all records
//		if (owner.getLastName() == null) {
//			owner.setLastName(""); // empty string signifies broadest possible search
//		}
//
//		// find owners by last name
//		Page<Owner> ownersResults = findPaginatedForOwnersLastName(page, owner.getLastName());
//		if (ownersResults.isEmpty()) {
//			// no owners found
//			result.rejectValue("lastName", "notFound", "not found");
//			return "owners/findOwners";
//		}
//
//		if (ownersResults.getTotalElements() == 1) {
//			// 1 owner found
//			owner = ownersResults.iterator().next();
//			return "redirect:/owners/" + owner.getId();
//		}
//
//		// multiple owners found
//		return addPaginationModel(page, model, ownersResults);
//	}

	private String addPaginationModel(int page, Model model, Page<Owner> paginated) {
		List<Owner> listOwners = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listOwners", listOwners);
		return "owners/ownersList";
	}
//
//	private Page<Owner> findPaginatedForOwnersLastName(int page, String lastname) {
//		int pageSize = 5;
//		Pageable pageable = PageRequest.of(page - 1, pageSize);
//		return owners.findByLastName(lastname, pageable);
//	}
//
//	@GetMapping("/owners/{ownerId}/edit")
//	public String initUpdateOwnerForm(@PathVariable("ownerId") int ownerId, Model model) {
//		Owner owner = this.owners.findById(ownerId);
//		model.addAttribute(owner);
//		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//	}

//	@PostMapping("/owners/{ownerId}/edit")
//	public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result,
//			@PathVariable("ownerId") int ownerId) {
//		if (result.hasErrors()) {
//			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//		}
//
//		owner.setId(ownerId);
//		this.owners.save(owner);
//		return "redirect:/owners/{ownerId}";
//	}

//	@GetMapping("/owners/{ownerId}")
//	public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
//		ModelAndView mav = new ModelAndView("owners/ownerDetails");
//		Owner owner = this.owners.findById(ownerId);
//		mav.addObject(owner);
//		return mav;
//	}
	@GetMapping("/")
	public String ss(){
		return "welcome";
	}

}
