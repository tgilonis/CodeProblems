'''
the input expression for polish notation:

Expression
- valid only if the number of operands + 1 == number of variables
- can also just be a single integer, in which case we just compare that to the max val     

Could be recursive, but probably better to just do it iteratively


'''

#first, we need to find a way to interpret the polish notation
#for an operation, we need an operator and two integers

#operators are written before their operands


#as such, we can search from the left, find an operator, then look two right to find the operands

def max_result_expression(expression: str):
    exp = expression.replace(" ", "")
    exp = [x for x in exp]
    for x in exp:
        print(x)
    if len(exp)==1:
        if(exp[0] in ["+","-","*","/"]):
            return
        else:
            return exp[0]

print(max_result_expression("+ 1            2"))