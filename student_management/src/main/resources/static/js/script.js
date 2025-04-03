document.addEventListener('DOMContentLoaded', function() {
    console.log('Student Management System loaded');
    
    // Example: Add confirmation for delete actions
    const deleteButtons = document.querySelectorAll('.btn-danger');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            if (!confirm('Are you sure you want to delete this student?')) {
                e.preventDefault();
            }
        });
    });
});