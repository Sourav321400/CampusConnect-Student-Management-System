# Manual testing checklist
Run these tests locally and record actual outcomes before marking them passed.

| Test | Action | Expected result |
|---|---|---|
| T1 | Open `/CampusConnect/students` with database configured | Student list loads |
| T2 | Add student with unique email | New record appears |
| T3 | Submit missing required fields | Form validation message appears |
| T4 | Add duplicate email | Duplicate-email message appears |
| T5 | Edit existing record | Updated details appear |
| T6 | Delete existing record | Record is removed |
| T7 | Open edit using unknown ID | Not-found response |
| T8 | Stop MySQL and reload | Database error is logged by the server |
